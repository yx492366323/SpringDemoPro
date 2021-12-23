package com.zjw.Service.Impl;

import com.zjw.Domain.User_Video;
import com.zjw.Mapper.User_VideoMapper;
import com.zjw.Mapper.VideoMapper;
import com.zjw.Service.User_VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User_VideoServiceImpl implements User_VideoService {
    @Autowired
    private User_VideoMapper userVideoMapper;
    @Autowired
    private VideoMapper videoMapper;

    public Integer countByUsername(String username){
        return userVideoMapper.countByUsername(username);
    }
    public Integer count1(String username){
        return videoMapper.count()-userVideoMapper.countByUsername(username);
    }
    public Integer countByVideoname(String videoname){
        return userVideoMapper.countByVideoname(videoname);
    }
    public List<User_Video> findByUsername(String username){
        return userVideoMapper.findByUsername(username);
    }
}
