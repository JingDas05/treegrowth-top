package top.treegrowth.provider.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import top.treegrowth.model.entity.Page;
import top.treegrowth.provider.dao.mapper.PageMapper;
import top.treegrowth.provider.service.IPageService;
import top.treegrowth.provider.serviceImpl.bo.PageDetail;
import top.treegrowth.provider.serviceImpl.bo.PagePure;

import java.util.Date;

import static top.treegrowth.common.utils.Generator.uuid;

/**
 * @author wusi
 * @version 2017/4/1 7:25.
 */
@Service
public class PageServiceImpl implements IPageService {

    @Autowired
    private PageMapper pageMapper;

    public PageDetail getPageDetail(Page page, String userId) {
        PageDetail pageDetail = new PageDetail();
        pageDetail.setId(page.getId());
        pageDetail.setName(page.getName());
        pageDetail.setContent(page.getContent());
        pageDetail.setDiaryId(pageDetail.getDiaryId());
        pageDetail.setWeather(pageDetail.getWeather());
        pageDetail.setMind(pageDetail.getMind());
        pageDetail.setCreateTime(page.getCreateTime());
        if (!StringUtils.isEmpty(userId)) {
            fillInWithUserState(pageDetail, userId);
        }
        return pageDetail;
    }


    @Transactional
    @Override
    public PageDetail createPage(PagePure pagePure) {
        Page page = pagePure.toPage();
        page.setId(uuid());
        page.setCreateTime(new Date());
        pageMapper.createPage(page);
        return getPageDetail(page, pagePure.getAuthorId());
    }

    private void fillInWithUserState(PageDetail pageDetail, String userId) {

    }
}
