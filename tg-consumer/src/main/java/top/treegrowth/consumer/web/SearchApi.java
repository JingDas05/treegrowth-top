package top.treegrowth.consumer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @RequestMapping(method = POST)
    PageRes<PageDetail> search(@RequestBody QueryReq queryReq) {
        return searchService.search(queryReq);
    }
}
