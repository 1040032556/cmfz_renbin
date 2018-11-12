package com.baizhi.entity;

import java.util.List;

public class Menu {
    private String id;
    private String name;
    private String iconCls;
    private String href;
    private List<Menu> zmenu;

    public Menu() {
    }

    public Menu(String id, String name, String iconCls, String href, List<Menu> zmenu) {
        this.id = id;
        this.name = name;
        this.iconCls = iconCls;
        this.href = href;
        this.zmenu = zmenu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<Menu> getZmenu() {
        return zmenu;
    }

    public void setZmenu(List<Menu> zmenu) {
        this.zmenu = zmenu;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", href='" + href + '\'' +
                ", zmenu=" + zmenu +
                '}';
    }
}
