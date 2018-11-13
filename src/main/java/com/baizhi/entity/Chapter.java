package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//id title size duration(时长) downPath uploadTime(Date)
public class Chapter {
    private String id;
    private String title;
    private String size;
    private String duration;
    private String downPath;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date uploadTime;
    private String album_id;

    public Chapter(String id, String title, String size, String duration, String downPath, Date uploadTime, String album_id) {
        this.id = id;
        this.title = title;
        this.size = size;
        this.duration = duration;
        this.downPath = downPath;
        this.uploadTime = uploadTime;
        this.album_id = album_id;
    }

    public Chapter() {
        super();
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", size='" + size + '\'' +
                ", duration='" + duration + '\'' +
                ", downPath='" + downPath + '\'' +
                ", uploadTime=" + uploadTime +
                ", album_id='" + album_id + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDownPath() {
        return downPath;
    }

    public void setDownPath(String downPath) {
        this.downPath = downPath;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }
}
