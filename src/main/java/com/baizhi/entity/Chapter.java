package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Chapter {
    private String id;
    private String title;
    private String downPath;
    private String size;
    private String duration;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date uploadTime;
    Album album;

    public Chapter() {
    }

    public Chapter(String id, String title, String downPath, String size, String duration, Date uploadTime, Album album) {
        this.id = id;
        this.title = title;
        this.downPath = downPath;
        this.size = size;
        this.duration = duration;
        this.uploadTime = uploadTime;
        this.album = album;
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

    public String getDownPath() {
        return downPath;
    }

    public void setDownPath(String downPath) {
        this.downPath = downPath;
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

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", downPath='" + downPath + '\'' +
                ", size='" + size + '\'' +
                ", duration='" + duration + '\'' +
                ", uploadTime=" + uploadTime +
                ", album=" + album +
                '}';
    }
}
