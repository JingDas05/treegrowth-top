package top.treegrowth.redis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
import top.treegrowth.model.redis.PureIdentifyCode;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Repository
public class RedisDao {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //String 操作模板
    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> valOpsStr;


    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    //object 操作模板
    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> valOps;

    public void SetIdentifyCode(PureIdentifyCode pureIdentifyCode) {
        valOpsStr.set(
                pureIdentifyCode.getPhoneNum(),
                pureIdentifyCode.getCode(),
                pureIdentifyCode.getExpiry(),
                TimeUnit.SECONDS);
    }

    public String GetIdentifyCode(String phoneNum) {
        return valOpsStr.get(phoneNum);
    }
}
