package top.treegrowth.provider.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.treegrowth.model.user.PureUser;
import top.treegrowth.model.user.ReturnUser;
import top.treegrowth.provider.service.UserService;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author wusi
 * @version 2017/2/7.
 */
@RestController
@RequestMapping("api/service/users")
public class UserApi {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/identify-code", method = POST)
    public void getIdentifyCode(@RequestParam("phone") String phone) {
        userService.getIdentifyCode(phone);
    }

    @RequestMapping(method = POST)
    public ReturnUser phoneRegister(@RequestBody PureUser pureUser) throws Exception {
        return userService.phoneRegister(pureUser);
    }
}
