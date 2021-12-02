package com.zjw.Mapper;

import com.zjw.Domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    User selectUserByInfo(String username);
    List<User> fineUsersByField(@Param("Field") String Field, @Param("Value") String Value);
    int delUserById(Integer Id);
    int modUser(@Param("Field") String Field, @Param("Value") String Value, @Param("Id") Integer Id);
    int insUser(User user);
}
