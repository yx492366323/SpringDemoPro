package com.zjw.Mapper;

import com.zjw.Domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {
    User selectUserByInfo(String username);
    List<User> fineUsersByField(@Param("Field") String Field, @Param("Value") String Value);
}
