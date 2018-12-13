package com.sunfy.yy.culture.controller;

import com.sunfy.yy.culture.domain.Culture_Famous;
import com.sunfy.yy.common.domain.Result;
import com.sunfy.yy.common.enums.CultureApiEnum;
import com.sunfy.yy.culture.repository.Culture_Famous_Repository;
import com.sunfy.yy.culture.service.Culture_Famous_Service;
import com.sunfy.yy.common.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 名人名言控制器
 */
@RestController
public class Culture_Famous_Controller {

    private final static Logger logger = LoggerFactory.getLogger(Culture_Famous_Controller.class);

    @Autowired
    private Culture_Famous_Repository culture_famous_repository;

    @Autowired
    private Culture_Famous_Service culture_famous_service;

    /**
     * 查询所有的名人名言（列表get请求）
     * @return
     */
    @GetMapping(value = "famous/{keyword}")
    public Result<Culture_Famous> famousList(@PathVariable("keyword") String keyword,
                                             @RequestParam("rows") Integer rows,
                                             @RequestParam("page") Integer page){
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Famous_Controller—famousList】请求成功！");
        }
        String url = CultureApiEnum.FAMOUS.getURL();
        url += "&keyword="+keyword;
        if(!rows.equals("") && rows != null){
            url += "&rows="+rows;
        }
        if(!page.equals("") && page != null){
            url += "&page="+page;
        }
        return ResultUtil.success(culture_famous_service.addFamous(url));
    }

    /**
     * 查询名人名言（随机返回一条get请求）
     * @return
     */
    @GetMapping(value = "famousRandom")
    @Scheduled(fixedRate = 10*1000)
    @Async
    public Result<Culture_Famous> famousRandom(){
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Famous_Controller—famousRandom】请求成功！");
        }
        String url = CultureApiEnum.FAMOUS_RANDOM.getURL();
        return ResultUtil.success(culture_famous_service.addFamousRandom(url));
    }

    /**
     * 插入名人名言（单条Post请求）
     * @param culture_famous 待插入对象
     * @param bindingResult 返回结果
     * @return Result<Culture_Famous
     */
    @PostMapping(value = "famous")
    public Result<Culture_Famous> famous(@Valid Culture_Famous culture_famous, BindingResult bindingResult){
        //插入数据出现异常
        if(bindingResult.hasErrors()){
            //将错误信息打印出来
            return  ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        //将数据写入数据库，并返回当前对象
        return ResultUtil.success(culture_famous_repository.save(culture_famous));
    }
}
