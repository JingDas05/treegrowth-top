package top.treegrowth.consumer.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.treegrowth.consumer.security.model.TgUser;
import top.treegrowth.consumer.service.PageService;
import top.treegrowth.model.req.PagePure;
import top.treegrowth.model.req.PagesReq;
import top.treegrowth.model.req.group.Create;
import top.treegrowth.model.res.*;

import java.security.Principal;

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

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/create", method = POST)
    public PageDetail createPage(@RequestBody @Validated({Create.class}) PagePure pagePure, @AuthenticationPrincipal TgUser tgUser) {
        pagePure.setAuthorId(tgUser.getId());
        return pageService.createPage(pagePure);
    }

    //    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/getByPeriod", method = POST)
    public PageRes<PageDetail> getPagesBetween(@RequestBody PagesReq pagesReq, @AuthenticationPrincipal TgUser tgUser) {
        pagesReq.setUserId(tgUser == null ? null : tgUser.getId());
        return pageService.getPagesBetween(pagesReq);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/delete/{userId}/{pageId}", method = POST)
    public ItemRes<Boolean> deletePages(@PathVariable String userId, @PathVariable String pageId, @AuthenticationPrincipal TgUser tgUser) {
        userId = tgUser.getId();
        return pageService.deletePages(userId, pageId);
    }

//    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/detail/{pageId}", method = GET)
    public ItemRes<PageDetail> getPageDetailBy(@PathVariable("pageId") String pageId,
                                               @AuthenticationPrincipal TgUser tgUser) {
        String userId = tgUser == null ? "" : tgUser.getId();
        return pageService.getPageDetailBy(userId, pageId);
    }
}
