package com.sunfy.yy.culture.controller;

import com.sunfy.yy.common.domain.Result;
import com.sunfy.yy.common.enums.EnumCultureApi;
import com.sunfy.yy.common.enums.EnumCultureException;
import com.sunfy.yy.common.utils.ResultUtil;
import com.sunfy.yy.culture.domain.Culture_Dic;
import com.sunfy.yy.culture.repository.Culture_Dic_Repository;
import com.sunfy.yy.culture.service.Culture_Dic_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

/**
 * 字典控制器
 */
@RestController
public class Culture_Dic_Controller {

    private final static Logger logger = LoggerFactory.getLogger(Culture_Dic_Controller.class);

    @Autowired
    private Culture_Dic_Repository culture_dic_repository;

    @Autowired
    private Culture_Dic_Service culture_dic_service;

    /**
     * 查询字典列表（get请求）
     * @return
     */
    @GetMapping(value = "dic/{keyword}")
    public Result<Culture_Dic> dicList(@PathVariable("keyword") String keyword){
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Dic_Controller—dicList】请求成功！");
        }
        String url = EnumCultureApi.DIC.getURL();
        url += "&content="+keyword;
        ArrayList list = culture_dic_service.addDic(url);
        if(list != null && list.size() > 0){
            return ResultUtil.success(list);
        }
        return ResultUtil.error(EnumCultureException.ERROR_NULL);
    }

    /**
     * 插入字典(单条Post请求)
     * @param culture_dic 待插入对象
     * @param bindingResult 返回结果
     * @return Result<Culture_Famous
     */
    @PostMapping(value = "dic")
    public Result<Culture_Dic> famous(@Valid Culture_Dic culture_dic, BindingResult bindingResult){
        //插入数据出现异常
        if(bindingResult.hasErrors()){
            //将错误信息打印出来
            return  ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        //将数据写入数据库，并返回当前对象
        @Valid Culture_Dic list = culture_dic_repository.save(culture_dic);
        if(list != null){
            return ResultUtil.success(list);
        }
        return ResultUtil.error(EnumCultureException.ERROR_NULL);
    }
}
