package top.treegrowth.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.treegrowth.service.InstanceService;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author wusi
 * @version 20170203
 */
@RestController
public class ServiceInstanceRestController {

    @Autowired
    private InstanceService instanceService;

    @RequestMapping(value = "/service-instances/{applicationName}", method = GET)
    public String serviceInstancesByApplicationName(@PathVariable("applicationName") String applicationName) {
        return instanceService.getInstances(applicationName);
    }
}
