package com.zjw.Domain;

import java.sql.Time;
import java.sql.Timestamp;

public class User_Video {

    private String username;
    private String filename;
    private Timestamp time;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
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
                ", filename='" + filename + '\'' +
                ", time=" + time +
                '}';
    }
}
