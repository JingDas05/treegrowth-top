package top.treegrowth.provider.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.treegrowth.model.entity.Diary;

import java.util.List;

/**
 * @author wusi
 * @version 2017/3/31 7:10.
 */
@Mapper
public interface DiaryMapper {

    void createDiary(Diary diary);

    Diary getDiaryBy(@Param("diaryId") String diaryId, @Param("userId") String userId);

    List<Diary> getDiaries(@Param("userId") String userId);
}
