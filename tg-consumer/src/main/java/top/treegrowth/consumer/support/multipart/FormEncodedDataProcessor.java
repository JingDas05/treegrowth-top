package top.treegrowth.consumer.support.multipart;

import feign.RequestTemplate;

import java.net.URLEncoder;
import java.util.Map;

import static feign.Util.UTF_8;

/**
 * Form urlencoded implementation of {@link feign.form.FormDataProcessor}.
 *
 * @author Artem Labazin <xxlabaza@gmail.com>
 * @since 30.04.2016
 */
public class FormEncodedDataProcessor implements FormDataProcessor{
    public static final String CONTENT_TYPE;

    static {
        CONTENT_TYPE = "application/x-www-form-urlencoded";
    }

    @Override
    public void process (Map<String, Object> data, RequestTemplate template) {
        val body = new StringBuilder();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            if (body.length() > 0) {
                body.append('&');
            }
            body.append(createKeyValuePair(entry));
        }

        template.header("Content-Type", CONTENT_TYPE);
        template.body(body.toString());
    }

    @Override
    public String getSupportetContentType () {
        return CONTENT_TYPE;
    }

    @SneakyThrows
    private String createKeyValuePair (Map.Entry<String, Object> entry) {
        return new StringBuilder()
                .append(URLEncoder.encode(entry.getKey(), UTF_8.name()))
                .append('=')
                .append(URLEncoder.encode(entry.getValue().toString(), UTF_8.name()))
                .toString();
    }
}
