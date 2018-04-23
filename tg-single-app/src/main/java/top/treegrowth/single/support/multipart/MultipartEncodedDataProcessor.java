package top.treegrowth.single.support.multipart;

import feign.RequestTemplate;

import java.io.*;
import java.net.URLConnection;
import java.util.Map;

import static feign.Util.UTF_8;

/**
 * 自己构建multipart的header，之后远程调用
 *
 * Multipart form data implementation of {@link top.treegrowth.consumer.support.multipart.FormEncoder}.
 *
 * @author Artem Labazin <xxlabaza@gmail.com>
 * @since 30.04.2016
 */
public class MultipartEncodedDataProcessor implements FormDataProcessor{

    public static final String CONTENT_TYPE;
    private static final String CRLF;

    static {
        CONTENT_TYPE = "multipart/form-data";
        CRLF = "\r\n";
    }

    @Override
    public void process (Map<String, Object> data, RequestTemplate template) {
        //构建边界
        String boundary = createBoundary();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            PrintWriter writer = new PrintWriter(outputStream);
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                writer.append("--").append(boundary).append(CRLF);
                if (isPayload(entry.getValue())) {
                    writeByteOrFile(outputStream, writer, entry.getKey(), entry.getValue());
                } else {
                    writeParameter(writer, entry.getKey(), entry.getValue().toString());
                }
                writer.append(CRLF).flush();
            }
            writer.append("--").append(boundary).append("--").append(CRLF).flush();
        } catch (Throwable throwable) {
            try {
                outputStream.close();
            } catch (IOException ex) {
            }
            throw throwable;
        }
        String contentType = new StringBuilder()
                .append(CONTENT_TYPE)
                .append("; boundary=")
                .append(boundary)
                .toString();

        template.header("Content-Type", contentType);
        template.body(outputStream.toByteArray(), UTF_8);
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getSupportetContentType () {
        return CONTENT_TYPE;
    }

    //检查传递的object是否是文件类型
    protected boolean isPayload (Object value) {
        return value != null && (value instanceof File || value instanceof byte[]);
    }

    /**
     * Writes file's content to output stream.
     *
     * @param output  output stream to remote destination.
     * @param writer  wrapped output stream.
     * @param name  the name of the file.
     * @param value  file's content. Byte array or {@link File}.
     */
    protected void writeByteOrFile (OutputStream output, PrintWriter writer, String name, Object value) {
        if (value instanceof byte[]) {
            writeByteArray(output, writer, name, null, null, (byte[]) value);
        } else {
            writeFile(output, writer, name, null, (File) value);
        }
    }

    private String createBoundary () {
        return Long.toHexString(System.currentTimeMillis());
    }

    private void writeParameter (PrintWriter writer, String name, String value) {
        writer.append("Content-Disposition: form-data; name=\"" + name + "\"").append(CRLF);
        writer.append("Content-Type: text/plain; charset=UTF-8").append(CRLF);
        writer.append(CRLF).append(value);
    }

    /**
     * Writes file to output stream as a {@link File}.
     *
     * @param output  output stream to remote destination.
     * @param writer  wrapped output stream.
     * @param name  the name of the file.
     * @param contentType  the content type (if known).
     * @param file  file object.
     */
    protected void writeFile (OutputStream output, PrintWriter writer, String name, String contentType, File file) {
        writeFileMeta(writer, name, file.getName(), contentType);
        InputStream input = null;
        try {
            input = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        writer.flush();
    }

    /**
     * Writes file's content to output stream as a byte array.
     *
     * @param output  utput stream to remote destination.
     * @param writer  wrapped output stream.
     * @param name  the name of the file.
     * @param originalFilename  the original filename (as on the client's machine).
     * @param contentType  the content type (if known).
     * @param bytes  file's content.
     */
    protected void writeByteArray (OutputStream output,
                                   PrintWriter writer,
                                   String name,
                                   String originalFilename,
                                   String contentType,
                                   byte[] bytes
    ) {
        //将元信息写入到 writer, 这个name是前端传递进来的form数据里的key
        writeFileMeta(writer, name, originalFilename, contentType);
        try {
            output.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.flush();
    }

    //将元信息写入到writer，之后调用flush()将信息写入outputStream, name:前台传递进来的form数据的key
    private void writeFileMeta (PrintWriter writer, String name, String fileName, String contentValue) {
        String contentDisposition = new StringBuilder()
                .append("Content-Disposition: form-data; name=\"").append(name).append("\"; ")
                .append("filename=\"").append(fileName).append("\"")
                .toString();
        if (contentValue == null) {
            contentValue = fileName != null ? URLConnection.guessContentTypeFromName(fileName) : "application/octet-stream";
        }
        String contentType = new StringBuilder()
                .append("Content-Type: ")
                .append(contentValue)
                .toString();
        writer.append(contentDisposition).append(CRLF);
        writer.append(contentType).append(CRLF);
        writer.append("Content-Transfer-Encoding: binary").append(CRLF);
        writer.append(CRLF).flush();
    }
}
