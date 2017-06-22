package top.treegrowth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wusi
 * @version 20170203
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
//为了查看MapperScannerRegistrar源码引入
//@MapperScan(basePackages = {"top.treegrowth.provider.dao.mapper"})
public class ProviderApplication {


    public static void main(String[] args) {
        new SpringApplicationBuilder(ProviderApplication.class).web(true).run(args);
    }
}
