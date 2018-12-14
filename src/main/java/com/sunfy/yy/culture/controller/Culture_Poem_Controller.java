package com.sunfy.yy.culture.controller;

import com.sunfy.yy.common.domain.Result;
import com.sunfy.yy.common.enums.EnumCultureApi;
import com.sunfy.yy.common.enums.EnumCultureException;
import com.sunfy.yy.common.utils.ResultUtil;
import com.sunfy.yy.culture.domain.Culture_Poem;
import com.sunfy.yy.culture.repository.Culture_Poem_Repository;
import com.sunfy.yy.culture.service.Culture_Poem_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Map;

/**
 * 唐诗宋词控制器
 */
@RestController
public class Culture_Poem_Controller {

    private final static Logger logger = LoggerFactory.getLogger(Culture_Poem_Controller.class);

    @Autowired
    private Culture_Poem_Repository culture_poem_repository;

    @Autowired
    private Culture_Poem_Service culture_poem_service;

    /**
     * 查询唐诗宋词
     * @return
     */
    @GetMapping(value = "poem/{keyword}")
    public Result<Culture_Poem> poemList(@PathVariable("keyword") String keyword,
                                         @RequestParam("rows") Integer rows,
                                         @RequestParam("page") Integer page){
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Poem_Controller—poemList】请求成功！");
        }
        String url = EnumCultureApi.POEM.getURL();
        url += "&keyWord="+keyword;
        if(!rows.equals("") && rows != null){
            url += "&rows="+rows;
        }
        if(!page.equals("") && page != null){
            url += "&page="+page;
        }
        ArrayList list = culture_poem_service.addPoemList(url);
        if(list != null && list.size() > 0){
            return ResultUtil.success(list);
        }
        return ResultUtil.error(EnumCultureException.ERROR_NULL);
    }

    /**
     * 查询唐诗宋词单个
     * @return
     */
    @GetMapping(value = "poemDetails/{id}")
    public Result<Culture_Poem> poemDetails(@PathVariable("id") String id){
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Poem_Controller—poemDetails】请求成功！");
        }
        String url = EnumCultureApi.POEM_DETAILS.getURL();
        url += "&id="+id;
        ArrayList list = culture_poem_service.addPoem(url);
        if(list != null && list.size() > 0){
            return ResultUtil.success(list);
        }
        return ResultUtil.error(EnumCultureException.ERROR_NULL);
    }


    /**
     * 随机返回唐诗宋词
     * @return
     */
    @GetMapping(value = "poemRandom")
    public Result<Culture_Poem> poemRandom(){
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Poem_Controller—poemRandom】请求成功！");
        }
        String url = EnumCultureApi.POEM_RANDOM.getURL();
        Map map = culture_poem_service.addPoemRandom(url);
        if(map != null && !map.isEmpty()){
            return ResultUtil.success(map);
        }
        return ResultUtil.error(EnumCultureException.ERROR_NULL);
    }

    /**
     * 插入唐诗宋词
     * @param culture_poem 待插入对象
     * @param bindingResult 返回结果
     * @return Result<Culture_Famous
     */
    @PostMapping(value = "poem")
    public Result<Culture_Poem> famous(@Valid Culture_Poem culture_poem, BindingResult bindingResult){
        //插入数据出现异常
        if(bindingResult.hasErrors()){
            //将错误信息打印出来
            return  ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        //将数据写入数据库，并返回当前对象
        if(culture_poem_repository.save(culture_poem) != null){
            return ResultUtil.success(culture_poem_repository.save(culture_poem));
        }
        @Valid Culture_Poem list = culture_poem_repository.save(culture_poem);
        if(list != null){
            return ResultUtil.success(list);
        }
        return ResultUtil.error(EnumCultureException.ERROR_NULL);
    }
}
