package top.treegrowth.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.treegrowth.model.entity.User;
import top.treegrowth.model.res.PureUser;
import top.treegrowth.model.res.ReturnUser;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author wusi
 * @version 2017/4/4 23:27.
 */

@FeignClient("provider")
@RequestMapping("api/service/users")
public interface UserService {

    @RequestMapping(value = "/code", method = GET)
    void getIdentifyCode(@RequestParam("phone") String phone);

    @RequestMapping(method = POST)
    ReturnUser phoneRegister(@RequestBody PureUser pureUser);

    @RequestMapping(value = "/phone", method = GET)
    User findUserByPhone(@RequestParam("phone") String phone);
}
