package com.health.dao;

import com.health.pojo.CheckItem;

import java.util.List;

/**
 * @Author LiuJunShi
 * @create 2020/1/10 20:35
 */
public interface CheckItemDao {
    void addCheckItem(CheckItem checkItem);
    List<CheckItem> findPage(String queryString);
    void deleteCheckItemById(Integer id);
}
