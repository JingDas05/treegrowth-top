package top.treegrowth.provider.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.treegrowth.model.entity.Diary;
import top.treegrowth.model.entity.Page;

/**
 * @author wusi
 * @version 2017/3/31 7:10.
 */
@Mapper
public interface PageMapper {

    void createPage(Page page);

    Page getPageBy(@Param("pageId") String pageId);
}
