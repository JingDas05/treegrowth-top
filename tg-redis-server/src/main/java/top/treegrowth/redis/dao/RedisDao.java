package top.treegrowth.redis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class RedisDao {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //String 操作模板
    @Resource(name="stringRedisTemplate")
    ValueOperations<String,String> valOpsStr;


    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    //object 操作模板
    @Resource(name="redisTemplate")
    ValueOperations<Object, Object> valOps;


}
