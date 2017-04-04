package top.treegrowth.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import top.treegrowth.model.elastic.QueryReq;
import top.treegrowth.model.response.PageDetail;
import top.treegrowth.model.response.PageRes;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author wusi
 * @version 2017/4/4 23:27.
 */

@FeignClient("provider")
@RequestMapping(value = "api/service/search")
public interface SearchService {

    @RequestMapping(method = POST)
    PageRes<PageDetail> search(@RequestBody QueryReq queryReq);
}
