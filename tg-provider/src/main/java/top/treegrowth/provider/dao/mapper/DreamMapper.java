package top.treegrowth.provider.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.treegrowth.model.entity.Dream;

/**
 * @author wusi
 * @version 2017/3/18 19:30.
 */
@Mapper
public interface DreamMapper {

    void addDream(Dream dream);

    Dream getDreamBy(@Param("id") String id);
}
