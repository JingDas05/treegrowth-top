package top.treegrowth.provider.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.treegrowth.provider.service.IPageService;
import top.treegrowth.provider.serviceImpl.bo.PageDetail;
import top.treegrowth.provider.serviceImpl.bo.PagePure;

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
}
