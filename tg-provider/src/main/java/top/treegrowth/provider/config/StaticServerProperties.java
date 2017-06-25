package top.treegrowth.provider.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author wusi
 * @version 2017/6/25 19:43.
 */
@ConfigurationProperties(prefix = "top.treegrowth.staticServer")
public class StaticServerProperties {

    private String uri;
    private String dataPath;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getDataPath() {
        return dataPath;
    }

    public void setDataPath(String dataPath) {
        this.dataPath = dataPath;
    }
}
