package top.treegrowth.provider.service;

import top.treegrowth.provider.serviceImpl.bo.PageDetail;
import top.treegrowth.provider.serviceImpl.bo.PagePure;
import top.treegrowth.provider.serviceImpl.bo.PagesReq;
import top.treegrowth.provider.serviceImpl.bo.response.ItemRes;
import top.treegrowth.provider.serviceImpl.bo.response.PageRes;

import java.util.List;

/**
 * @author wusi
 * @version 2017/4/1 7:19.
 */
public interface IPageService {

    PageDetail createPage(PagePure pagePure);

    PageRes<PageDetail> getPagesBetween(PagesReq pagesReq);

    ItemRes<Boolean> deleteBy(String pageId);
}
