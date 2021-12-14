package com.zjw.Domain;

import java.sql.Time;
import java.sql.Timestamp;

public class Video {
    private Integer id;
    private String name;
    private String filename;
    private Time time;
    private String path;
    private String username;
    private Timestamp uploadtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Timestamp uploadtime) {
        this.uploadtime = uploadtime;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", filename='" + filename + '\'' +
                ", time=" + time +
                ", path='" + path + '\'' +
                ", username='" + username + '\'' +
                ", uploadtime=" + uploadtime +
                '}';
    }
}
