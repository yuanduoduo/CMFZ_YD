package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

// id title imgPath content publishDate(发布日期)
public class Article {
    private String id;
    private String title;
    private String imgPath;
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;
    private String guru_id;

    public Article(String id, String title, String imgPath, String content, Date publishDate, String guru_id) {
        this.id = id;
        this.title = title;
        this.imgPath = imgPath;
        this.content = content;
        this.publishDate = publishDate;
        this.guru_id = guru_id;
    }

    public Article() {
        super();
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", content='" + content + '\'' +
                ", publishDate=" + publishDate +
                ", guru_id='" + guru_id + '\'' +
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

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getGuru_id() {
        return guru_id;
    }

    public void setGuru_id(String guru_id) {
        this.guru_id = guru_id;
    }
}
