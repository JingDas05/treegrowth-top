package top.treegrowth.provider.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.treegrowth.common.utils.Generator;
import top.treegrowth.model.redis.PureIdentifyCode;
import top.treegrowth.model.user.PureUser;
import top.treegrowth.model.user.ReturnUser;
import top.treegrowth.model.user.User;
import top.treegrowth.provider.dao.mapper.UserMapper;
import top.treegrowth.provider.service.CodeService;
import top.treegrowth.provider.service.UserService;
import top.treegrowth.redis.dao.RedisDao;


import java.security.InvalidParameterException;
import java.util.Objects;

/**
 * @author wusi
 * @version 2017/2/7.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RedisDao redisDao;
    @Autowired
    UserMapper userMapper;
    @Autowired
    CodeService codeService;

    public ReturnUser phoneRegister(PureUser pureUser) throws Exception {
        String code = redisDao.getIdentifyCode(pureUser.getPhone());
        if (code == null || !Objects.equals(pureUser.getCode(), code)) {
            throw new InvalidParameterException(code);
        }
        User user = new User();
        user.setId(Generator.getId());
        user.setPassword(pureUser.getPassword());
        user.setPhone(pureUser.getPhone());
        userMapper.insertUser(user);
        return new ReturnUser(user);
    }

    @Override
    public void getIdentifyCode(String phone) {
        String code = Generator.getCode(6);
        codeService.sendIdentifyCode(phone, code);
        redisDao.setIdentifyCode(new PureIdentifyCode(phone, code, 600L));
    }
}
