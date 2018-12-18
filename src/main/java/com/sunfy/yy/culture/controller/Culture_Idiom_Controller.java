package com.sunfy.yy.culture.controller;

import com.sunfy.yy.common.domain.Result;
import com.sunfy.yy.common.enums.EnumCultureApi;
import com.sunfy.yy.common.enums.EnumCultureException;
import com.sunfy.yy.common.utils.ResultUtil;
import com.sunfy.yy.culture.domain.Culture_Idiom;
import com.sunfy.yy.culture.repository.Culture_Idiom_Repository;
import com.sunfy.yy.culture.service.Culture_Idiom_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

/**
 * 成语控制器
 */
@RestController
public class Culture_Idiom_Controller {

    private final static Logger logger = LoggerFactory.getLogger(Culture_Idiom_Controller.class);

    @Autowired
    private Culture_Idiom_Repository culture_idiom_repository;

    @Autowired
    private Culture_Idiom_Service culture_idiom_service;

    /**
     * 查询成语(get请求列表)
     * @return
     */
    @GetMapping(value = "idiom/{keyword}")
    public Result<Culture_Idiom> idiomList(@PathVariable("keyword") String keyword,
                                           @RequestParam("rows") Integer rows,
                                           @RequestParam("page") Integer page){
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Idiom_Controller—idiomList】请求成功！");
        }
        String url = EnumCultureApi.IDIOM.getURL();
        url += "&keyword="+keyword;
        if(!rows.equals("") && rows != null){
            url += "&rows="+rows;
        }
        if(!page.equals("") && page != null){
            url += "&page="+page;
        }
        ArrayList list = culture_idiom_service.addIdiomList(url);
        if(list != null && list.size() > 0){
            return ResultUtil.success(list);
        }
        return ResultUtil.error(EnumCultureException.ERROR_NULL);
    }

    /**
     * 查询成语详情
     * @return
     */
    @GetMapping(value = "idiomDetails/{id}")
    public Result<Culture_Idiom> idiomDetails(@PathVariable("id") String id){
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Idiom_Controller—idiomDetails】请求成功！");
        }
        String url = EnumCultureApi.IDIOM_DETAILS.getURL();
        if(!id.equals("") && id != null){
            url += "&id="+id;
        }
        ArrayList list = culture_idiom_service.addIdiom(url);
        if(list != null && list.size() > 0){
            return ResultUtil.success(list);
        }
        return ResultUtil.error(EnumCultureException.ERROR_NULL);
    }

    /**
     * 随机返回一条成语
     * @return
     */
    @GetMapping(value = "idiomRandom")
    public Result<Culture_Idiom> idiomRandom(){
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Idiom_Controller—idiomRandom】请求成功！");
        }
        String url = EnumCultureApi.IDIOM_RANDOM.getURL();
        ArrayList list = culture_idiom_service.addIdiomRandom(url);
        if(list != null && !list.isEmpty()){
            return ResultUtil.success(list);
        }
        return ResultUtil.error(EnumCultureException.ERROR_NULL);
    }

    /**
     * 插入成语
     * @param culture_idiom 待插入对象
     * @param bindingResult 返回结果
     * @return Result<Culture_Famous
     */
    @PostMapping(value = "idiom")
    public Result<Culture_Idiom> famous(@Valid Culture_Idiom culture_idiom, BindingResult bindingResult){
        //插入数据出现异常
        if(bindingResult.hasErrors()){
            //将错误信息打印出来
            return  ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        //将数据写入数据库，并返回当前对象
        @Valid Culture_Idiom list = culture_idiom_repository.save(culture_idiom);
        if(list != null){
            return ResultUtil.success(list);
        }
        return ResultUtil.error(EnumCultureException.ERROR_NULL);
    }
}
