package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

// 专辑表(album)1
//    id title publishDate(发布日期) count coverImg(封面)
//    star(score) author broadCast  brief(简介)
public class Album {
    private String id;
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;
    private String count;
    private String coverImg;
    private String star;
    private String author;
    private String broadCast;
    private String brief;
    private List<Chapter> children;

    public Album() {
        super();
    }

    public Album(String id, String title, Date publishDate, String count, String coverImg, String star, String author, String broadCast, String brief, List<Chapter> children) {
        this.id = id;
        this.title = title;
        this.publishDate = publishDate;
        this.count = count;
        this.coverImg = coverImg;
        this.star = star;
        this.author = author;
        this.broadCast = broadCast;
        this.brief = brief;
        this.children = children;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", publishDate=" + publishDate +
                ", count='" + count + '\'' +
                ", coverImg='" + coverImg + '\'' +
                ", star='" + star + '\'' +
                ", author='" + author + '\'' +
                ", broadCast='" + broadCast + '\'' +
                ", brief='" + brief + '\'' +
                ", children=" + children +
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

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadCast() {
        return broadCast;
    }

    public void setBroadCast(String broadCast) {
        this.broadCast = broadCast;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }
}
