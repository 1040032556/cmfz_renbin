package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {
    private String id;
    private String phone;
    private String password;
    private String headPic;
    private String province;
    private String city;
    private String nickname;
    private String salt;
    private String sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String status;
    private Guru guru;

    public User() {
    }

    public User(String id, String phone, String password, String headPic, String province, String city, String nickname, String salt, String sex, Date birthday, String status, Guru guru) {
        this.id = id;
        this.phone = phone;
        this.password = password;
        this.headPic = headPic;
        this.province = province;
        this.city = city;
        this.nickname = nickname;
        this.salt = salt;
        this.sex = sex;
        this.birthday = birthday;
        this.status = status;
        this.guru = guru;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", headPic='" + headPic + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", nickname='" + nickname + '\'' +
                ", salt='" + salt + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", status='" + status + '\'' +
                ", guru=" + guru +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Guru getGuru() {
        return guru;
    }

    public void setGuru(Guru guru) {
        this.guru = guru;
    }
}
