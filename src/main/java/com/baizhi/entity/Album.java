package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Album {
    private String id;
    private String title;
    private Integer count;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date create_date;
    private Integer star;
    private String author;
    private String broadcast;
    private String brief;
    private String imgPath;
    List<Chapter> children;

    public Album() {
    }

    public Album(String id, String title, Integer count, Date create_date, Integer star, String author, String broadcast, String brief, String imgPath, List<Chapter> children) {
        this.id = id;
        this.title = title;
        this.count = count;
        this.create_date = create_date;
        this.star = star;
        this.author = author;
        this.broadcast = broadcast;
        this.brief = brief;
        this.imgPath = imgPath;
        this.children = children;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", count=" + count +
                ", create_date=" + create_date +
                ", star=" + star +
                ", author='" + author + '\'' +
                ", broadcast='" + broadcast + '\'' +
                ", brief='" + brief + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", children=" + children +
                '}';
    }
}
