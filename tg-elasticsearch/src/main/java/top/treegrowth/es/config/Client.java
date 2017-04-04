package top.treegrowth.es.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author wusi
 * @version 2017/4/3 23:59.
 */
@Configuration
public class Client {

    @Value(value = "${elastic.host}")
    private String host;
    @Value(value = "${elastic.port}")
    private int port;
    @Value(value = "${elastic.clusterName}")
    private String clusterName;


    @PostConstruct
    @Bean
    public TransportClient init() {

        Settings settings = Settings.builder().put("cluster.name", clusterName).build();
        TransportClient client = null;
        try {
            client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return client;
    }
}
