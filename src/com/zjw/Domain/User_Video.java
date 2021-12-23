package com.zjw.Domain;

import java.sql.Time;
import java.sql.Timestamp;

public class User_Video {

    private String username;
    private String videoname;
    private Timestamp time;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVideoname() {
        return videoname;
    }

    public void setVideoname(String videoname) {
        this.videoname = videoname;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "User_Video{" +
                "username='" + username + '\'' +
                ", videoname='" + videoname + '\'' +
                ", time=" + time +
                '}';
    }
}
