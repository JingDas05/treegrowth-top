package top.treegrowth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wusi
 * @version 20170203
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"top.treegrowth.provider.dao.mapper"})
public class ProviderApplication {


    public static void main(String[] args) {
        new SpringApplicationBuilder(ProviderApplication.class).web(true).run(args);
    }
}
