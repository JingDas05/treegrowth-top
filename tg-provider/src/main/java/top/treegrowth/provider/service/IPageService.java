package top.treegrowth.provider.service;

import top.treegrowth.model.response.*;

/**
 * @author wusi
 * @version 2017/4/1 7:19.
 */
public interface IPageService {

    PageDetail createPage(PagePure pagePure);

    PageRes<PageDetail> getPagesBetween(PagesReq pagesReq);

    ItemRes<Boolean> deleteBy(String pageId);
}
