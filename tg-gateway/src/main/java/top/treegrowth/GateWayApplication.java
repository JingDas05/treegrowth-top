package top.treegrowth;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author wusi
 * @version 2017/4/7 20:44.
 */
@EnableZuulProxy
@SpringCloudApplication
public class GateWayApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(GateWayApplication.class).web(true).run(args);
    }
}
