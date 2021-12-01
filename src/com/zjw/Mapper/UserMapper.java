package com.zjw.Mapper;

import com.zjw.Domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserMapper {
    User selectUserByAll(String username);
}
