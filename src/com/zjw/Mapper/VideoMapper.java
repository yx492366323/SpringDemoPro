package com.zjw.Mapper;

import com.zjw.Domain.Video;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VideoMapper {
    Video selectFileByname(String name);
    int insVideo(Video video);
}
