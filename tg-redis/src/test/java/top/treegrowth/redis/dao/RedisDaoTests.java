package top.treegrowth.redis.dao;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import top.treegrowth.model.redis.PureIdentifyCode;
import top.treegrowth.redis.config.RedisConfig;

import static org.assertj.core.api.BDDAssertions.then;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RedisDao.class, RedisConfig.class},
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RedisDaoTests {

    static ConfigurableApplicationContext context;

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @BeforeClass
    public static void startEureka() {
        context = SpringApplication.run(EurekaServer.class,
                "--server.port=1111",
                "--eureka.instance.leaseRenewalIntervalInSeconds=1");
    }

    @AfterClass
    public static void closeEureka() {
        context.close();
    }

    @Test
    public void shouldRegisterRedisServer() throws Exception {

        Thread.sleep(3000);

        PureIdentifyCode pureIdentifyCode = new PureIdentifyCode();
        pureIdentifyCode.setPhoneNum("15640909868");
        pureIdentifyCode.setCode("5566");
        pureIdentifyCode.setExpiry(20L);

        this.restTemplate.postForEntity("http://localhost:" + this.port + "/api/service/redis/identifyCode", pureIdentifyCode, null);
        ResponseEntity<String> response = this.restTemplate.getForEntity(
                "http://localhost:" + this.port + "/api/service/redis/{phoneNum}",
                String.class, "15640909868");
        then(response.getBody()).isEqualTo("5566");

        Thread.sleep(21000);
        ResponseEntity<String> responseExpire = this.restTemplate.getForEntity(
                "http://localhost:" + this.port + "/api/service/redis/{phoneNum}",
                String.class, "15640909868");
        then(responseExpire.getBody()).isEqualTo("already expire");
    }

    @Configuration
    @EnableAutoConfiguration
    @EnableEurekaServer
    static class EurekaServer {
    }
}
