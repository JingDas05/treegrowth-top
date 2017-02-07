package top.treegrowth.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.treegrowth.model.user.PureUser;
import top.treegrowth.model.user.ReturnUser;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@FeignClient("tg-provider")
@RequestMapping("api/service/users")
public interface UserService {

    @RequestMapping(value = "api/users/identify-code", method = POST)
    void getIdentifyCode(@RequestParam("phone") String phone);

    @RequestMapping(method = POST)
    ReturnUser phoneRegister(@RequestBody PureUser pureUser) throws Exception;
}
