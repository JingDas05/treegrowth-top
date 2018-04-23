package top.treegrowth;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wusi
 */
@SpringBootApplication
@EnableTransactionManagement
public class SingleAppApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SingleAppApplication.class).web(true).run(args);
    }
}
