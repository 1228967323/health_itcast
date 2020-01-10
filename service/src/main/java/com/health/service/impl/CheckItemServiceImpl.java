package com.health.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.health.dao.CheckItemDao;
import com.health.pojo.CheckItem;
import com.health.pojo.PageResult;
import com.health.pojo.QueryPageBean;
import com.health.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author LiuJunShi
 * @create 2020/1/10 20:46
 */
@Service(interfaceClass = CheckItemService.class)
public class CheckItemServiceImpl implements CheckItemService {
    @Autowired
    private CheckItemDao checkItemDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addCheckItem(CheckItem checkItem) {
        checkItemDao.addCheckItem(checkItem);
        int i = 10 / 0;
    }

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        if (!StringUtils.isEmpty(queryPageBean.getQueryString())){
            queryPageBean.setCurrentPage(1);
        }
        PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
        List<CheckItem> checkItems = checkItemDao.findPage(queryPageBean.getQueryString());
        PageInfo<CheckItem> pageInfo = new PageInfo<>(checkItems);
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());

    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteCheckItem(Integer id) {
        checkItemDao.deleteCheckItemById(id);
    }

}
