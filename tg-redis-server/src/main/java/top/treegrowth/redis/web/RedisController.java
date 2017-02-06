package top.treegrowth.redis.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.treegrowth.model.redis.PureIdentifyCode;
import top.treegrowth.redis.dao.RedisDao;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "api/redis")
public class RedisController {

    @Autowired
    private RedisDao redisDao;

    @RequestMapping(value = "/identifyCode", method = POST)
    public void SetIdentifyCode(@RequestBody PureIdentifyCode pureIdentifyCode) {
        redisDao.SetIdentifyCode(pureIdentifyCode);
    }

    @RequestMapping(value = "/identifyCode/{phoneNum}", method = GET)
    public String GetIdentifyCode(@PathVariable(value = "phoneNum") String phoneNum) {
        return redisDao.GetIdentifyCode(phoneNum);
    }

}
