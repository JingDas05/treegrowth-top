package top.treegrowth.service;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author wusi
 * @version 20170203
 */
@FeignClient("tg-provider")
public interface InstanceService {

    @RequestMapping("/service-instances/{applicationName}")
    List<ServiceInstance> getInstances(@PathVariable String applicationName);
}
