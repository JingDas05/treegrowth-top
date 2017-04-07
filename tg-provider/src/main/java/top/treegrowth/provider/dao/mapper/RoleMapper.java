package top.treegrowth.provider.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.treegrowth.model.entity.Role;

/**
 * @author wusi
 * @version 2017/4/7 21:49.
 */
@Mapper
public interface RoleMapper {

    Role getRoleByCode(@Param("roleId") String roleId);
}
