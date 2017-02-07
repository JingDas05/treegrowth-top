package top.treegrowth.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import top.treegrowth.model.redis.PureIdentifyCode;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author wusi
 * @version 2017/2/7.
 */
@FeignClient("tg-redis-provider")
public interface RedisService {

    @RequestMapping(value = "api/service/redis/identifyCode", method = POST)
    void setIdentifyCode(@RequestBody PureIdentifyCode pureIdentifyCode);

    @RequestMapping(value = "api/service/redis/{phoneNum}", method = GET)
    String getIdentifyCode(@PathVariable(value = "phoneNum") String phoneNum);
}
