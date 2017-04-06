package top.treegrowth.provider.web.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import javax.annotation.PostConstruct;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static top.treegrowth.common.utils.Constants.DATE_FORMAT;

/**
 * @author wusi
 * @version 2017/4/3 8:32.
 */
@Configuration
public class HttpMessageDateConverter {

    @Autowired
    private ObjectMapper objectMapper;

    private HttpMessageConverter<Object> httpMessageConverter;

    @PostConstruct
    public void init() {
        httpMessageConverter = new MappingJackson2HttpMessageConverter(objectMapper);
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        objectMapper.setDateFormat(dateFormat);
    }

}
