package top.treegrowth.single.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.treegrowth.model.req.PagePure;
import top.treegrowth.model.req.PagesReq;
import top.treegrowth.model.res.ItemRes;
import top.treegrowth.model.res.PageDetail;
import top.treegrowth.model.res.PageRes;
import top.treegrowth.single.service.IPageService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author wusi
 * @version 2017/4/1 7:10.
 */
@RestController
@RequestMapping(value = "/api/service/pages")
public class PageApi {

    @Autowired
    private IPageService pageService;

    @RequestMapping(value = "/create", method = POST)
    public PageDetail createPage(@RequestBody PagePure pagePure) {
        return pageService.createPage(pagePure);
    }

    @RequestMapping(value = "/getByPeriod", method = POST)
    public PageRes<PageDetail> getPagesBetween(@RequestBody PagesReq pagesReq) {
        return pageService.getPagesBetween(pagesReq);
    }

    @RequestMapping(value = "/delete/{userId}/{pageId}", method = POST)
    public ItemRes<Boolean> deletePages(@PathVariable("userId") String userId,
                                        @PathVariable("pageId") String pageId) {
        return pageService.deleteBy(userId, pageId);
    }

    @RequestMapping(value = "/detail", method = GET)
    public ItemRes<PageDetail> getPageDetailBy(@RequestParam("userId") String userId,
                                               @RequestParam("pageId") String pageId) {
        return pageService.getPageDetailBy(userId, pageId);
    }
}
