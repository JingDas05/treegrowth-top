package top.treegrowth.provider.dao.mapper;

import org.apache.ibatis.annotations.*;
import top.treegrowth.model.entity.User;


@Mapper
public interface UserMapper {

    @Insert("INSERT into tg_users(id,name,password,phone) VALUES(#{id},#{name},#{password},#{phone})")
    void insertUser(User user);

    @Delete("DELETE FROM tg_users where id =#{id}")
    void deleteUser(Long id);

    @Update("UPDATE tg_users SET id=#{id}, name=#{name}")
    void updateUser(User user);

    @Select("SELECT * from tg_users WHERE id=#{id}")
    User selectUser(Long id);
}
