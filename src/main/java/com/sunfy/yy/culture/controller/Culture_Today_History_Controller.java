package com.sunfy.yy.culture.controller;

import com.sunfy.yy.common.domain.Result;
import com.sunfy.yy.common.utils.ResultUtil;
import com.sunfy.yy.culture.domain.Culture_Today_History;
import com.sunfy.yy.culture.repository.Culture_Today_History_Repository;
import com.sunfy.yy.culture.service.Culture_Today_History_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 历史上的今天控制器
 */
@RestController
public class Culture_Today_History_Controller {

    private final static Logger logger = LoggerFactory.getLogger(Culture_Today_History_Controller.class);

    @Autowired
    private Culture_Today_History_Repository culture_today_history_repository;

    @Autowired
    private Culture_Today_History_Service culture_today_history_service;

    /**
     * 查询历史上的今天
     * @return
     */
    @GetMapping(value = "today_history")
    public Result<Culture_Today_History> today_HistoryList(@RequestParam("yue") Integer yue,
                                                           @RequestParam("ri") Integer ri,
                                                           @RequestParam("type") Integer type){
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Today_History_Controller—today_HistoryList】请求成功！");
        }
        String url ="https://api.avatardata.cn/HistoryToday/LookUp?key=a8f8ad8a787c4abca058a1a306423158";
        if(!yue.equals("") && yue != null){
            url += "&yue=1";
        }
        if(!ri.equals("") && ri != null){
            url += "&ri=1";
        }
        if(!type.equals("") && type != null){
            url += "&type=1";
        }
        return ResultUtil.success(culture_today_history_service.addToday_History(url));
    }

    /**
     * 插入历史上的今天
     * @param culture_today_history 待插入对象
     * @param bindingResult 返回结果
     * @return Result<Culture_Famous
     */
    @PostMapping(value = "today_history")
    public Result<Culture_Today_History> today_History(@Valid Culture_Today_History culture_today_history, BindingResult bindingResult){
        //插入数据出现异常
        if(bindingResult.hasErrors()){
            //将错误信息打印出来
            return  ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        //将数据写入数据库，并返回当前对象
        return ResultUtil.success(culture_today_history_repository.save(culture_today_history));
    }
}
