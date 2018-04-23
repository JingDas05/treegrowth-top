package top.treegrowth.single.support.multipart;

import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Map;

/**
 *
 * todo feign 远程上传throws exception Current request is not a multipart request,所以暂时改成直接调用 provider 3333端口
 *
 * Adds support for {@link MultipartFile} type to {@link FormEncoder}.
 *
 * @author Tomasz Juchniewicz <tjuchniewicz@gmail.com>
 * @since 14.09.2016
 */
public class SpringFormEncoder extends FormEncoder{

    // 这个地方应用的应该是 SpringEncoder
    private final Encoder delegate;

    public SpringFormEncoder () {
        this(new Encoder.Default());
    }

    public SpringFormEncoder(Encoder delegate) {
        this.delegate = delegate;
    }

    @Override
    public void encode(Object object, Type bodyType, RequestTemplate template) throws EncodeException {
        if (!bodyType.equals(MultipartFile.class)) {
            delegate.encode(object, bodyType, template);
            return;
        }

        MultipartFile file = (MultipartFile) object;
        Map<String, Object> data = Collections.singletonMap(file.getName(), object);
        new SpringMultipartEncodedDataProcessor().process(data, template);
    }
}
