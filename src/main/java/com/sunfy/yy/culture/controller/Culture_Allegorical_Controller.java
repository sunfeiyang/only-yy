package com.sunfy.yy.culture.controller;

import com.sunfy.yy.common.domain.Result;
import com.sunfy.yy.common.enums.EnumCultureApi;
import com.sunfy.yy.common.enums.EnumCultureException;
import com.sunfy.yy.common.utils.ResultUtil;
import com.sunfy.yy.culture.domain.Culture_Allegorical;
import com.sunfy.yy.culture.repository.Culture_Allegorical_Repository;
import com.sunfy.yy.culture.service.Culture_Allegorical_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

/**
 * 歇后语控制器
 */
@RestController
public class Culture_Allegorical_Controller {

    private final static Logger logger = LoggerFactory.getLogger(Culture_Allegorical_Controller.class);

    @Autowired
    private Culture_Allegorical_Repository culture_allegorical_repository;

    @Autowired
    private Culture_Allegorical_Service culture_allegorical_service;

    /**
     * 查询歇后语列表（get请求）
     * @return
     */
    @GetMapping(value = "allegorical/{keyword}")
    public Result<Culture_Allegorical> allegoricalList(@PathVariable("keyword") String keyword,
                                                       @RequestParam("rows") Integer rows,
                                                       @RequestParam("page") Integer page){
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Allegorical_Controller—allegoricalList】请求成功！");
        }
        String url = EnumCultureApi.ALLEGORICAL.getURL();
        url += "&keyword="+keyword;
        if(!rows.equals("") && rows != null){
            url += "&rows="+rows;
        }
        if(!page.equals("") && page != null){
            url += "&page="+page;
        }
        ArrayList<Culture_Allegorical> result_list = culture_allegorical_service.addAllegorical(url);
        if(result_list != null){
            return ResultUtil.success(result_list);
        }
        return ResultUtil.error(EnumCultureException.ERROR_NULL);
    }

    /**
     * 随机返回一条
     * @return
     */
    @GetMapping(value = "allegoricalRandom")
    public Result<Culture_Allegorical> allegoricalRandom(){
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Allegorical_Controller—allegoricalRandom】请求成功！");
        }
        String url = EnumCultureApi.ALLEGORICAL_RANDOM.getURL();
        ArrayList<Culture_Allegorical> result_list = culture_allegorical_service.addAllegoricalRandom(url);
        if(result_list != null){
            return ResultUtil.success(result_list);
        }
        return ResultUtil.error(EnumCultureException.ERROR_NULL);
    }

    /**
     * 插入歇后语（单条数据插入Post请求）
     * @param culture_allegorical 待插入对象
     * @param bindingResult 返回结果
     * @return Result<Culture_Famous>
     */
    @PostMapping(value = "allegorical")
    public Result<Culture_Allegorical> allegorical(@Valid Culture_Allegorical culture_allegorical, BindingResult bindingResult){
        //插入数据出现异常
        if(bindingResult.hasErrors()){
            //将错误信息打印出来
            return  ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        //将数据写入数据库，并返回当前对象
        @Valid Culture_Allegorical list = culture_allegorical_repository.save(culture_allegorical);
        if(list != null){
            return ResultUtil.success(list);
        }
        return ResultUtil.error(EnumCultureException.ERROR_NULL);
    }
}
