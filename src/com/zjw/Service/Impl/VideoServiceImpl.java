package com.zjw.Service.Impl;

import com.zjw.Domain.User;
import com.zjw.Domain.Video;
import com.zjw.Mapper.UserMapper;
import com.zjw.Mapper.VideoMapper;
import com.zjw.Service.UserService;
import com.zjw.Service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;

    public Video selectFileByname(String name){return videoMapper.selectFileByname(name);}

    public Boolean insVideo(Video video){return 1==videoMapper.insVideo(video);}

    public List<Video> fineVideosByField(String Field, String Value) {
        return videoMapper.fineVideosByField(Field,Value);
    }

    public Boolean delVideoById(Integer Id) {
        return 1==videoMapper.delVideoById(Id);
    }

    public Boolean modVideo(String Field, String Value, Integer Id) {
        return 1==videoMapper.modVideo(Field,Value,Id);
    }

}
