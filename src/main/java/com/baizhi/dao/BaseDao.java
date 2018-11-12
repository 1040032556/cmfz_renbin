package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDao<T>{
    //添加
    void insert(T t);
    //查询
    T query(T t);
    //查询id
    T queryOneById(String id);
    //删除
    void delete(String id);
    //修改
    void update(T t);
    //查询所有
    List<T> queryMore();

    //参数1：起始条数；参数2：每页显示的记录数
    List<T> queryByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    Long queryTotals();
}
