package top.treegrowth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author wusi
 * @version 20170203
 */
@SpringBootApplication
@MapperScan(basePackages = {"top.treegrowth.provider.dao.mapper"})
//@EnableDiscoveryClient
//@EnableFeignClients
public class ProviderApplication {

    // TODO: 2017/2/6 这个地方添加了 @EnableFeignClients，不知道会对provider是否有影响，需要添加测试

    public static void main(String[] args) {
        new SpringApplicationBuilder(ProviderApplication.class).web(true).run(args);
    }
}
