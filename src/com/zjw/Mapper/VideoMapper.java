package com.zjw.Mapper;

import com.zjw.Domain.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VideoMapper {
    Video selectFileByname(String name);
    int insVideo(Video video);
    List<Video> fineVideosByField(@Param("Field") String Field, @Param("Value") String Value);
    int delVideoById(Integer Id);
    int modVideo(@Param("Field") String Field, @Param("Value") String Value, @Param("Id") Integer Id);
    int count();
    List<Video>findByUsername0(String username);
    List<Video>findByUsername1(String username);
}
