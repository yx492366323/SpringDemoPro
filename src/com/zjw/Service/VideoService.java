package com.zjw.Service;

import com.zjw.Domain.User;
import com.zjw.Domain.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface VideoService {

    Video selectFileByname(String name);

    Boolean insVideo(Video video);

    List<Video> fineVideosByField(String Field, String Value);

    Boolean delVideoById(Integer Id);

    Boolean modVideo(String Field, String Value, Integer Id);
}
