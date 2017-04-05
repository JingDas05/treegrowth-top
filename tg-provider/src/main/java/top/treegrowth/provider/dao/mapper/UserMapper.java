package top.treegrowth.provider.dao.mapper;

import org.apache.ibatis.annotations.*;
import top.treegrowth.model.entity.User;

import java.util.List;


@Mapper
public interface UserMapper {

    void createUser(User user);

    void deleteUserBy(@Param("userId") String userId);

    void updateUser(User user);

    User getUserBy(@Param("userId") String userId);

    List<User> getUsers();
}
