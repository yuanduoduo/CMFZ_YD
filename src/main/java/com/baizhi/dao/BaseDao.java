package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDao<T> {
    void insert(T t);

    void update(T t);

    void delete(String id);

    T queryOne(T t);

    List<T> queryAll();

    T queryById(String id);

    //参数1:起始条数 //参数2:每页显示的记录数
    List<T> queryByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    Long queryTotals();

}
