package top.treegrowth.consumer.security.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import java.util.EnumSet;

import static javax.servlet.DispatcherType.REQUEST;

/**
 * @author wusi
 * @version 2017/4/19 6:57.
 */
@Configuration
public class FilterStartup implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class)
                .addMappingForUrlPatterns(EnumSet.of(REQUEST), false, "/*");
    }
}
