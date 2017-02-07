package top.treegrowth.provider.service;

import top.treegrowth.model.user.PureUser;
import top.treegrowth.model.user.ReturnUser;

/**
 * @author wusi
 * @version 2017/2/7.
 */
public interface UserService {

    ReturnUser phoneRegister(PureUser pureUser) throws Exception;

    void getIdentifyCode(String phone);
}
