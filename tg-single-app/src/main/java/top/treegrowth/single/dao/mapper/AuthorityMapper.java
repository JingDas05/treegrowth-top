package top.treegrowth.single.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.treegrowth.model.entity.Authority;

/**
 * @author wusi
 * @version 2017/4/7 22:04.
 */
@Mapper
public interface AuthorityMapper {

    Authority getAuthorityById(@Param("authorityId") String authorityId);
}
