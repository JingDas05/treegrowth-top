package top.treegrowth.provider.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.treegrowth.model.res.PureUser;
import top.treegrowth.model.res.ReturnUser;
import top.treegrowth.provider.service.IUserService;
import top.treegrowth.provider.serviceImpl.exception.ServiceException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author wusi
 * @version 2017/2/7.
 */
@RestController
@RequestMapping("api/service/users")
public class UserApi {

    @Autowired
    private IUserService IUserService;

    @RequestMapping(value = "/identify-code", method = GET)
    public String getIdentifyCode(@RequestParam("phone") String phone) throws ServiceException {
        return IUserService.getIdentifyCode(phone);
    }

    @RequestMapping(method = POST)
    public ReturnUser phoneRegister(@RequestBody PureUser pureUser) throws ServiceException {
        return IUserService.phoneRegister(pureUser);
    }
}
