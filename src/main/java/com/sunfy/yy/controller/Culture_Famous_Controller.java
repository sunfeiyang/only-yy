package com.sunfy.yy.controller;

import com.sunfy.yy.domain.Culture_Famous;
import com.sunfy.yy.domain.Result;
import com.sunfy.yy.repository.Culture_Famous_Repository;
import com.sunfy.yy.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 名人名言控制器
 */
@RestController
public class Culture_Famous_Controller {

    @Autowired
    private Culture_Famous_Repository culture_famous_repository;

    /**
     * 查询所有的名人名言
     * @return
     */
    @GetMapping(value = "famous")
    public Result<Culture_Famous> famousList(){
        return ResultUtil.success(culture_famous_repository.findAll());
    }

    /**
     * 插入名人名言
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
        //数据正常时写入数据
        //culture_famous.setFamous_name(culture_famous.getFamous_name());
        //culture_famous.setFamous_saying(culture_famous.getFamous_saying());
        //将数据写入数据库，并返回当前对象
        return ResultUtil.success(culture_famous_repository.save(culture_famous));
    }
}
