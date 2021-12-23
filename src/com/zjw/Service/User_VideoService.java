package com.zjw.Service;

import com.zjw.Domain.User_Video;

import java.util.List;

public interface User_VideoService {
    Integer countByUsername(String username);
    Integer count1(String username);
    Integer countByVideoname(String videoname);
    List<User_Video> findByUsername(String username);
    Boolean insUserVideo (User_Video userVideo);
}
