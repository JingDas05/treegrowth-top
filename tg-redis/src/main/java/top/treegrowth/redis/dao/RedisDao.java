package top.treegrowth.redis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
import top.treegrowth.model.redis.PureIdentifyCode;

import javax.annotation.Resource;
import java.util.Set;
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

    @Resource(name = "redisTemplate")
    SetOperations<String, Object> setOps;

    public void setIdentifyCode(PureIdentifyCode pureIdentifyCode) {
        valOpsStr.set(
                pureIdentifyCode.getPhoneNum(),
                pureIdentifyCode.getCode(),
                pureIdentifyCode.getExpiry(),
                TimeUnit.SECONDS);
    }

    public String getIdentifyCode(String phoneNum) {
        return valOpsStr.get(phoneNum);
    }

    public void set(String key, Object object) {
        setOps.add(key, object);
    }

    public Set<Object> getSet(String key) {
        return setOps.members(key);
    }
}
