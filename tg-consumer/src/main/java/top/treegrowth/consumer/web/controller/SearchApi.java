package top.treegrowth.consumer.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.treegrowth.consumer.security.model.TgUser;
import top.treegrowth.consumer.service.SearchService;
import top.treegrowth.model.elastic.QueryReq;
import top.treegrowth.model.res.PageDetail;
import top.treegrowth.model.res.PageRes;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author wusi
 * @version 2017/4/4 10:37.
 */
@RestController
@RequestMapping(value = "api/search")
public class SearchApi {

    @Autowired
    private SearchService searchService;

//    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = POST)
    PageRes<PageDetail> search(@RequestBody QueryReq queryReq, @AuthenticationPrincipal TgUser tgUser) {
        queryReq.setUserId(tgUser == null ? null : tgUser.getId());
        return searchService.search(queryReq);
    }
}
