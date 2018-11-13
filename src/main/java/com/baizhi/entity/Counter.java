package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//id title count recordDate user_id course_id
public class Counter {
    private String id;
    private String title;
    private String count;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date recordDate;
    private String user_id;
    private String course_id;

    public Counter(String id, String title, String count, Date recordDate, String user_id, String course_id) {
        this.id = id;
        this.title = title;
        this.count = count;
        this.recordDate = recordDate;
        this.user_id = user_id;
        this.course_id = course_id;
    }

    public Counter() {
        super();
    }

    @Override
    public String toString() {
        return "Counter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", count='" + count + '\'' +
                ", recordDate=" + recordDate +
                ", user_id='" + user_id + '\'' +
                ", course_id='" + course_id + '\'' +
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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }
}
