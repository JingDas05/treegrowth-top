package top.treegrowth.single.service;

import top.treegrowth.model.entity.User;
import top.treegrowth.model.res.PureUser;
import top.treegrowth.model.res.ReturnUser;
import top.treegrowth.single.serviceimpl.exception.ServiceException;

/**
 * @author wusi
 * @version 2017/2/7.
 */
public interface IUserService {

    ReturnUser phoneRegister(PureUser pureUser) throws ServiceException;

    String getIdentifyCode(String phone);

    User findUserByPhone(String phone);
}
