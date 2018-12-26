package com.sunfy.yy.culture.controller;

import com.sunfy.yy.common.domain.Result;
import com.sunfy.yy.common.enums.EnumApi;
import com.sunfy.yy.common.enums.EnumException;
import com.sunfy.yy.common.utils.ResultUtil;
import com.sunfy.yy.common.utils.UtilsAboutController;
import com.sunfy.yy.culture.domain.Culture_WordSea;
import com.sunfy.yy.culture.repository.Culture_WordSea_Repository;
import com.sunfy.yy.culture.service.Culture_WordSea_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 名人名言控制器
 */
@RestController
public class Culture_WordSea_Controller {

    private final static Logger logger = LoggerFactory.getLogger(Culture_WordSea_Controller.class);

    @Autowired
    private Culture_WordSea_Repository culture_wordSea_repository;

    @Autowired
    private Culture_WordSea_Service culture_wordSea_service;

    /**
     * 查询所有的名人名言（列表get请求）
     * @return
     */
    @GetMapping(value = "wordsea/{keyword}")
    public Result addList(@PathVariable("keyword") String keyword,
                          @RequestParam("rows") Integer rows,
                          @RequestParam("page") Integer page){
        if(logger.isInfoEnabled()){
            logger.info("【Culture_WordSea_Controller—addList】请求成功！");
        }
        String url = EnumApi.WORD_SEA.getURL();
        url += "&keyword="+keyword;
        if(!rows.equals("") && rows != null){
            url += "&rows="+rows;
        }
        if(!page.equals("") && page != null){
            url += "&page="+page;
        }
        ArrayList result_list = culture_wordSea_service.addList(url);
        return UtilsAboutController.setResult(result_list);
    }

    /**
     * 查询名人名言（随机返回一条get请求）
     * @return
     */
    @GetMapping(value = "wordseaRandom")
    public Result famousRandom(){
        if(logger.isInfoEnabled()){
            logger.info("【Culture_WordSea_Controller—famousRandom】请求成功！");
        }
        String url = EnumApi.WORD_SEA_RANDOM.getURL();
        ArrayList result_list = culture_wordSea_service.addRandom(url);
        return UtilsAboutController.setResult(result_list);
    }

    /**
     * 分页查询(请求数据库)
     * @return
     */
    @GetMapping(value = "selwordseaPage/{keyword}")
    public Result selListPage(@RequestParam("pageSize") Integer pageSize,
                              @RequestParam("pageNum") Integer pageNum){
        if(logger.isInfoEnabled()){
            logger.info("【Culture_WordSea_Controller—selListPage】请求成功！");
        }
        Map map = new HashMap();
        map.put("pageSize",pageSize);
        map.put("pageNum",pageNum);
        List result_list = culture_wordSea_service.selListPage(map);
        return UtilsAboutController.setResult(result_list);
    }
    /**
     * 查询成语(请求数据库)
     * @return
     */
    @GetMapping(value = "selwordsea/{keyword}")
    public Result selList(@PathVariable("keyword") String keyword){
        if(logger.isInfoEnabled()){
            logger.info("【Culture_WordSea_Controller—selList】请求成功！");
        }
        Map map = new HashMap();
        map.put("keyword",keyword);
        ArrayList result_list = culture_wordSea_service.selLikeList(map);
        return UtilsAboutController.setResult(result_list);
    }


    /**
     * 插入名人名言（单条Post请求）
     * @param culture_wordSea 待插入对象
     * @param bindingResult 返回结果
     * @return Result<Culture_Famous
     */
    @PostMapping(value = "wordsea")
    public Result famous(@Valid Culture_WordSea culture_wordSea, BindingResult bindingResult){
        //插入数据出现异常
        if(bindingResult.hasErrors()){
            //将错误信息打印出来
            return  ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        //将数据写入数据库，并返回当前对象
        @Valid Culture_WordSea list = culture_wordSea_repository.save(culture_wordSea);
        if(list != null){
            return ResultUtil.success(list,EnumException.SUCCESS);
        }
        return ResultUtil.error(EnumException.ERROR_NULL);
    }
}
