package top.treegrowth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wusi
 * @version 20170204
 */
@EnableDiscoveryClient
@SpringBootApplication
public class RedisServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisServerApplication.class, args);
    }
}
