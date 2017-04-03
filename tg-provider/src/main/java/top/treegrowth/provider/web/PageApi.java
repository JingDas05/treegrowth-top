package top.treegrowth.provider.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.treegrowth.provider.service.IPageService;
import top.treegrowth.provider.serviceImpl.bo.PageDetail;
import top.treegrowth.provider.serviceImpl.bo.PagePure;
import top.treegrowth.provider.serviceImpl.bo.PagesReq;
import top.treegrowth.provider.serviceImpl.bo.response.ItemRes;
import top.treegrowth.provider.serviceImpl.bo.response.PageRes;

import java.util.List;

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

    @RequestMapping(value = "/delete/{pageId}", method = POST)
    public ItemRes<Boolean> deletePages(@PathVariable String pageId) {
        return pageService.deleteBy(pageId);
    }
}