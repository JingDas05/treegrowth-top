package top.treegrowth.provider.service;

import top.treegrowth.provider.serviceImpl.bo.PageDetail;
import top.treegrowth.provider.serviceImpl.bo.PagePure;

/**
 * @author wusi
 * @version 2017/4/1 7:19.
 */
public interface IPageService {

    PageDetail createPage(PagePure pagePure);
}
