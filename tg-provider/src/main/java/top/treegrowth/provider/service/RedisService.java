package top.treegrowth.provider.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import top.treegrowth.model.redis.PureIdentifyCode;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@FeignClient("tg-redis-provider")
@RequestMapping(value = "api/redis")
public interface RedisService {

    @RequestMapping(value = "/identifyCode", method = POST)
    void setIdentifyCode(@RequestBody PureIdentifyCode pureIdentifyCode);

    @RequestMapping(value = "/{phoneNum}", method = GET)
    String getIdentifyCode(@PathVariable(value = "phoneNum") String phoneNum);
}
