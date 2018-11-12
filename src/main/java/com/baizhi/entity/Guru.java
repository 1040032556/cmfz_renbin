package com.baizhi.entity;

public class Guru {
    private String id;
    private String headPic;
    private String name;
    private Integer status;
    private String sex;
    public Guru() {
    }

    public Guru(String id, String headPic, String name, Integer status, String sex) {
        this.id = id;
        this.headPic = headPic;
        this.name = name;
        this.status = status;
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Guru{" +
                "id='" + id + '\'' +
                ", headPic='" + headPic + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", sex='" + sex + '\'' +
                '}';
    }
}
