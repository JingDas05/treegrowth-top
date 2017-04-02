package top.treegrowth.provider.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.treegrowth.model.entity.Diary;
import top.treegrowth.model.entity.Page;

import java.util.Date;
import java.util.List;

/**
 * @author wusi
 * @version 2017/3/31 7:10.
 */
@Mapper
public interface PageMapper {

    void createPage(Page page);

    Page getPageBy(@Param("pageId") String pageId);

    List<Page> getPagesBetween(@Param("startTime") Date startTime, @Param("endTime") Date endTime, @Param("diaryId") String diaryId);
}
