package top.treegrowth.consumer.support.multipart;

import feign.codec.EncodeException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Adds support for {@link MultipartFile} type to {@link MultipartEncodedDataProcessor}.
 *
 * @author Tomasz Juchniewicz <tjuchniewicz@gmail.com>
 * @since 14.09.2016
 */
public class SpringMultipartEncodedDataProcessor extends MultipartEncodedDataProcessor {

    @Override
    protected boolean isPayload (Object value) {
        return super.isPayload(value) || value instanceof MultipartFile;
    }

    @Override
    protected void writeByteOrFile (OutputStream output, PrintWriter writer, String name, Object value) {
        if (value instanceof MultipartFile) {
            try {
                MultipartFile mpf = (MultipartFile) value;
                writeByteArray(output, writer, name, mpf.getOriginalFilename(), mpf.getContentType(), mpf.getBytes());
            } catch (IOException e) {
                throw new EncodeException("Can't encode MultipartFile", e);
            }
            return;
        }

        super.writeByteOrFile(output, writer, name, value);
    }
}
