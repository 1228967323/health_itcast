package com.health.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.health.comment.MessageConstant;
import com.health.pojo.CheckItem;
import com.health.pojo.PageResult;
import com.health.pojo.QueryPageBean;
import com.health.pojo.Result;
import com.health.service.CheckItemService;
import org.springframework.web.bind.annotation.*;

/**
 * @Author LiuJunShi
 * @create 2020/1/10 20:51
 */
@RestController
@RequestMapping("/checkItem")
public class CheckItemController {
    @Reference
    private CheckItemService checkItemService;
    @PostMapping("/add")
    public Result addCheckItem(@RequestBody CheckItem checkItem){
        checkItemService.addCheckItem(checkItem);
        return new Result(true, MessageConstant.ADD_CHECKITEM_SUCCESS);
    }
    @PostMapping("/page")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){

        return checkItemService.findPage(queryPageBean);
    }
    @DeleteMapping("delete/{id}")
    public Result deleteCheckItem(@PathVariable("id") Integer id){
        checkItemService.deleteCheckItem(id);
        return new Result(true, MessageConstant.DELETE_CHECKITEM_SUCCESS);
    }

}
