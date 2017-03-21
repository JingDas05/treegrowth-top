package top.treegrowth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ImportResource;

/**
 * @author wusi
 * @version 20170203
 */
@SpringBootApplication
@EnableDiscoveryClient
@ImportResource
//@MapperScan(basePackages = {"top.treegrowth.provider.dao.top.treegrowth.mapper"})
public class ProviderApplication {


    public static void main(String[] args) {
        new SpringApplicationBuilder(ProviderApplication.class).web(true).run(args);
    }
}
