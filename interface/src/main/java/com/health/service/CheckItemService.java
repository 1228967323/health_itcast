package com.health.service;

import com.health.pojo.CheckItem;
import com.health.pojo.PageResult;
import com.health.pojo.QueryPageBean;

/**
 * @Author LiuJunShi
 * @create 2020/1/10 20:41
 */
public interface CheckItemService {
    void addCheckItem(CheckItem checkItem);
    PageResult findPage(QueryPageBean queryPageBean);
    void deleteCheckItem(Integer id);
}
