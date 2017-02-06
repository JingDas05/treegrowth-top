package top.treegrowth.provider.dao.mapper;

import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Insert("INSERT into tg_users(id,name) VALUES(#{id},#{name})")
    void insertNote(Note note);

    @Delete("DELETE FROM tg_users where id =#{id}")
    void deleteNote(Long id);

    @Update("UPDATE tg_users SET id=#{id}, name=#{name}")
    void updateNote(Note note);

    @Select("SELECT * from tg_users WHERE id=#{id}")
    Note selectNote(Long id);
}
