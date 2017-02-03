package top.treegrowth.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.treegrowth.service.InstanceService;

import java.util.List;

/**
 * @author wusi
 * @version 20170203
 */
@RestController
public class ServiceInstanceRestController {

    @Autowired
    private InstanceService instanceService;

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
        return instanceService.getInstances(applicationName);
    }
}
