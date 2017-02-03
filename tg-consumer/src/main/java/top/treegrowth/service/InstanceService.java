package top.treegrowth.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wusi
 * @version 20170203
 */
@FeignClient("tg-provider")
public interface InstanceService {

    @RequestMapping("/service-instances/{applicationName}")
    String getInstances(@PathVariable("applicationName") String applicationName);
}
