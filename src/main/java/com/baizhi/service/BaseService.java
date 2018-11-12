package com.baizhi.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseService <T>{
    //添加
    void add(T t);

    //查询
    T find(T t);

    //查询
    T findOneById(String id);

    //删除
    void remove(String id);

    //修改
    void motify(T t);

    //查询所有
    List<T> findMore();

    //参数1：起始条数；参数2：每页显示的记录数
    List<T> findByPage(Integer page, Integer rows);

    Long findTotals();
}
