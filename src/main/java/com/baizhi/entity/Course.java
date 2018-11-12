package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Course {
    private String id;
    private String title;
    private Integer marking;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date create_date;

    public Course(String id, String title, Integer marking, Date create_date) {
        this.id = id;
        this.title = title;
        this.marking = marking;
        this.create_date = create_date;
    }

    public Course() {

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

    public Integer getMarking() {
        return marking;
    }

    public void setMarking(Integer marking) {
        this.marking = marking;
    }
    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", marking=" + marking +
                ", create_date=" + create_date +
                '}';
    }
}
