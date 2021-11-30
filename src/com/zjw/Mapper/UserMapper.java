package com.zjw.Mapper;

import com.zjw.Domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User selectUserByAll(String username);
}
