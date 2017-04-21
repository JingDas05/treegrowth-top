package top.treegrowth.consumer.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.treegrowth.consumer.service.PageService;
import top.treegrowth.model.req.PagePure;
import top.treegrowth.model.req.PagesReq;
import top.treegrowth.model.req.group.Create;
import top.treegrowth.model.res.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author wusi
 * @version 2017/4/1 7:10.
 */
@RestController
@RequestMapping(value = "/api/pages")
public class PageApi {

    @Autowired
    private PageService pageService;

    @RequestMapping(value = "/create", method = POST)
    public PageDetail createPage(@RequestBody @Validated({Create.class}) PagePure pagePure) {
        return pageService.createPage(pagePure);
    }

    @RequestMapping(value = "/getByPeriod", method = POST)
    public PageRes<PageDetail> getPagesBetween(@RequestBody PagesReq pagesReq) {
        return pageService.getPagesBetween(pagesReq);
    }

    @RequestMapping(value = "/delete/{userId}/{pageId}", method = POST)
    public ItemRes<Boolean> deletePages(@PathVariable String userId, @PathVariable String pageId) {
        return pageService.deletePages(userId, pageId);
    }

    @RequestMapping(value = "/{userId}/{pageId}", method = GET)
    public ItemRes<PageDetail> getPageDetailBy(@PathVariable("userId") String userId, @PathVariable("pageId") String pageId) {
        return pageService.getPageDetailBy(userId, pageId);
    }
}
