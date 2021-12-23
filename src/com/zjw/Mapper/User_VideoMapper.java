package com.zjw.Mapper;

import com.zjw.Domain.User_Video;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface User_VideoMapper {
    List<User_Video> findByUsername(String username);
    Integer countByUsername(String username);
    Integer countByVideoname(String videoname);
}
