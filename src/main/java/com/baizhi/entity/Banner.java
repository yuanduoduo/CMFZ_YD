package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//id  title imgPath  desc  status  date(创建时间)
public class Banner {
    private String id;
    private String title;
    private String descA;
    private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    private String imgPath;

    @Override
    public String toString() {
        return "Banner{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", descA='" + descA + '\'' +
                ", status='" + status + '\'' +
                ", createDate=" + createDate +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }

    public Banner() {
        super();
    }

    public Banner(String id, String title, String descA, String status, Date createDate, String imgPath) {
        this.id = id;
        this.title = title;
        this.descA = descA;
        this.status = status;
        this.createDate = createDate;
        this.imgPath = imgPath;
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

    public String getDescA() {
        return descA;
    }

    public void setDescA(String descA) {
        this.descA = descA;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
