package top.treegrowth.provider.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import top.treegrowth.common.utils.Generator;
import top.treegrowth.model.entity.User;
import top.treegrowth.model.redis.PureIdentifyCode;
import top.treegrowth.model.res.PureUser;
import top.treegrowth.model.res.ReturnUser;
import top.treegrowth.provider.dao.mapper.UserMapper;
import top.treegrowth.provider.service.ICodeService;
import top.treegrowth.provider.service.IUserService;
import top.treegrowth.provider.serviceImpl.exception.IdentifyCodeAlreadyExistException;
import top.treegrowth.provider.serviceImpl.exception.ServiceException;
import top.treegrowth.redis.dao.RedisDao;

import java.security.InvalidParameterException;

import static top.treegrowth.common.utils.Conditions.checkState;

/**
 * @author wusi
 * @version 2017/2/7.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    RedisDao redisDao;
    @Autowired
    UserMapper userMapper;
    @Autowired
    ICodeService ICodeService;

    public ReturnUser phoneRegister(PureUser pureUser) throws ServiceException {
        String code = redisDao.getIdentifyCode(pureUser.getPhone());
        checkState(!StringUtils.isEmpty(code) && pureUser.getCode().equals(code), () -> new InvalidParameterException(code));
        User user = new User();
        user.setId(Generator.uuid());
        user.setPassword(pureUser.getPassword());
        user.setPhone(pureUser.getPhone());
        userMapper.createUser(user);
        return new ReturnUser(user);
    }

    @Override
    public String getIdentifyCode(String phone) {
        String oldCode = redisDao.getIdentifyCode(phone);
        checkState(StringUtils.isEmpty(oldCode), () -> new IdentifyCodeAlreadyExistException("验证码已存在，请稍后再试"));
        String newCode = Generator.getCode(999999);
        ICodeService.sendIdentifyCode(phone, newCode);
        redisDao.setIdentifyCode(new PureIdentifyCode(phone, newCode, 600L));
        return newCode;
    }
}
