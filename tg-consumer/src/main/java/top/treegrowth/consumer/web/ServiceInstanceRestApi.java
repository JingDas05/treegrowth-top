package top.treegrowth.consumer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.treegrowth.consumer.service.InstanceService;


import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author wusi
 * @version 20170203
 */
@RestController
public class ServiceInstanceRestApi {

    @Autowired
    private InstanceService instanceService;

    @RequestMapping(value = "/service-instances/{applicationName}", method = GET)
    public String serviceInstancesByApplicationName(@PathVariable("applicationName") String applicationName) {
        return instanceService.getInstances(applicationName);
    }
}
