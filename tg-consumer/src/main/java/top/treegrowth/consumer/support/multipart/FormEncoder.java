package top.treegrowth.consumer.support.multipart;

import feign.RequestTemplate;
import feign.codec.Encoder;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Properly encodes requests with <b>application/x-www-form-urlencoded</b> and <b>multipart/form-data</b> Content-Type.
 * <p>
 * Also, the encoder has a <b>delegate</b> field for encoding non-form requests (like JSON or other).
 * <p>
 * Default <b>delegate</b> object is {@link feign.codec.Encoder.Default} instance.
 * <p>
 * Usage example:
 * <p>
 * <b>Declaring API interface:</b>
 * <pre>
 * interface SomeApi {
 *
 *     &#064;RequestLine("POST /json")
 *     &#064;Headers("Content-Type: application/json")
 *     void json (Dto dto);
 *
 *     &#064;RequestLine("POST /form")
 *     &#064;Headers("Content-Type: application/x-www-form-urlencoded")
 *     void from (@Param("field1") String field1, @Param("field2") String field2);
 *
 * }
 * </pre>
 * <p>
 * <b>Creating Feign client instance:</b>
 * <pre>
 * SomeApi api = Feign.builder()
 *       .encoder(new FormEncoder(new JacksonEncoder()))
 *       .target(SomeApi.class, "http://localhost:8080");
 * </pre>
 * <p>
 * Now it can handle JSON Content-Type by {@code feign.jackson.JacksonEncoder} and
 * form request by {@link top.treegrowth.consumer.support.multipart.FormEncoder}.
 *
 * @author Artem Labazin <xxlabaza@gmail.com>
 * @since 30.04.2016
 */
public class FormEncoder implements Encoder {

    private final Encoder delegate;
    private final Map<String, FormDataProcessor> processors;

    public FormEncoder () {
        this(new Encoder.Default());
    }

    /**
     * {@code FormEncoder} constructor with delegate encoder argument.
     * <p>
     * @param delegate delegate encoder for processing non-form requests.
     */
    public FormEncoder (Encoder delegate) {
        this.delegate = delegate;
        processors = new HashMap<>(2, 1.F);
        FormDataProcessor formEncodedDataProcessor = new FormEncodedDataProcessor();
        processors.put(formEncodedDataProcessor.getSupportetContentType().toLowerCase(), formEncodedDataProcessor);
        FormDataProcessor multipartEncodedDataProcessor = new MultipartEncodedDataProcessor();
        processors.put(multipartEncodedDataProcessor.getSupportetContentType().toLowerCase(), multipartEncodedDataProcessor);
    }

    @Override
    public void encode (Object object, Type bodyType, RequestTemplate template) {

        // 如果不是map数据类型的，就用默认的编码器
        if (!MAP_STRING_WILDCARD.equals(bodyType)) {
            delegate.encode(object, bodyType, template);
            return;
        }
        String formType = "";
        for (Map.Entry<String, Collection<String>> entry : template.headers().entrySet()) {
            // 寻找headers信息里的 Content-Type
            if (!entry.getKey().equalsIgnoreCase("Content-Type")) {
                continue;
            }
            // 寻找processors 里能处理的Content-Type
            for (String contentType : entry.getValue()) {
                if (contentType != null && processors.containsKey(contentType.toLowerCase())) {
                    formType = contentType;
                    break;
                }
            }
            if (!formType.isEmpty()) {
                break;
            }
        }

        if (formType.isEmpty()) {
            delegate.encode(object, bodyType, template);
            return;
        }

        @SuppressWarnings("unchecked")
        Map<String, Object> data = (Map<String, Object>) object;
        processors.get(formType).process(data, template);
    }
}
