package top.treegrowth.provider.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.treegrowth.model.entity.Diary;

/**
 * @author wusi
 * @version 2017/3/31 7:10.
 */
@Mapper
public interface DiaryMapper {

    void createDiary(Diary diary);
}
