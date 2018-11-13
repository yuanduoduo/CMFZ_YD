package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//id title marking(flag) creatTime(创建时间)
public class Course {
    private String id;
    private String title;
    private String marking;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date creatTime;

    public Course(String id, String title, String marking, Date creatTime) {
        this.id = id;
        this.title = title;
        this.marking = marking;
        this.creatTime = creatTime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", marking='" + marking + '\'' +
                ", creatTime=" + creatTime +
                '}';
    }

    public Course() {
        super();
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

    public String getMarking() {
        return marking;
    }

    public void setMarking(String marking) {
        this.marking = marking;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}
