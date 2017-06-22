package top.treegrowth.consumer.config;

import feign.codec.Encoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import top.treegrowth.consumer.support.multipart.SpringFormEncoder;


/**
 * @author wusi
 * @version 2017/6/22 7:27.
 */
@Configuration
public class MultipartSupportConfig {
    @Bean
    @Primary
    @Scope("prototype")
    public Encoder feignFormEncoder() {
        return new SpringFormEncoder();
    }
}
