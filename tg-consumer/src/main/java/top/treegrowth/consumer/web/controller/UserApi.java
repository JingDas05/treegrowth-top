package top.treegrowth.consumer.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.treegrowth.consumer.service.UserService;
import top.treegrowth.model.res.PureUser;
import top.treegrowth.model.res.ReturnUser;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author wusi
 * @version 20170207
 */

@RestController
@RequestMapping("api/users")
public class UserApi {


    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/code", method = GET)
    public void getIdentifyCode(@RequestParam("phone") String phone) {
        userService.getIdentifyCode(phone);
    }

    @RequestMapping(method = POST)
    public ReturnUser phoneRegister(@RequestBody @Validated PureUser pureUser) throws Exception {
        pureUser.setPassword(passwordEncoder.encode(pureUser.getPassword()));
        return userService.phoneRegister(pureUser);
    }
}
