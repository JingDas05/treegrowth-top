package top.treegrowth.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import top.treegrowth.model.req.PagePure;
import top.treegrowth.model.req.PagesReq;
import top.treegrowth.model.res.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author wusi
 * @version 2017/4/4 23:30.
 */
@FeignClient("provider")
@RequestMapping(value = "/api/service/pages")
public interface PageService {

    @RequestMapping(value = "/create", method = POST)
    PageDetail createPage(@RequestBody PagePure pagePure);

    @RequestMapping(value = "/getByPeriod", method = POST)
    PageRes<PageDetail> getPagesBetween(@RequestBody PagesReq pagesReq);

    @RequestMapping(value = "/diary", method = POST)
    PageRes<PageDetail> getPagesBy(@RequestBody PagesReq pagesReq);

    @RequestMapping(value = "/delete/{userId}/{pageId}", method = POST)
    ItemRes<Boolean> deletePages(@PathVariable("userId") String userId, @PathVariable("pageId") String pageId);

    @RequestMapping(value = "/{userId}/{pageId}", method = GET)
    ItemRes<PageDetail> getPageDetailBy(@PathVariable("userId") String userId, @PathVariable("pageId") String pageId);
}
