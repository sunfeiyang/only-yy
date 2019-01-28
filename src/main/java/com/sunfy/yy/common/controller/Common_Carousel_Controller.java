package com.sunfy.yy.common.controller;

import com.sunfy.yy.common.domain.Common_Carousel;
import com.sunfy.yy.common.domain.Result;
import com.sunfy.yy.common.enums.EnumException;
import com.sunfy.yy.common.repository.Common_Carousel_Repository;
import com.sunfy.yy.common.service.Common_Carousel_Service;
import com.sunfy.yy.common.utils.UtilsResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;

/**
 * 轮播图控制器
 */
@RestController
public class Common_Carousel_Controller {

    private static final Logger logger = LoggerFactory.getLogger(Common_Carousel_Controller.class);

    @Autowired
    private Common_Carousel_Repository common_carousel_repository;

    @Autowired
    private Common_Carousel_Service common_carousel_service;

    @PostMapping(value = "setCarousel")
    public Result setCommon_Carousel(@Valid Common_Carousel common_carousel, BindingResult bindingResult){
        if(logger.isInfoEnabled()){
            logger.info("【Common_Carousel_Controller—setCommon_Carousel】请求成功！");
        }
        if(bindingResult.hasErrors()){
            return UtilsResult.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        Common_Carousel list = common_carousel_repository.save(common_carousel);
        if(list != null){
            return UtilsResult.success(list, EnumException.SUCCESS);
        }
        return UtilsResult.error(EnumException.ERROR_NULL);
    }

    @GetMapping(value = "getCarousel")
    public Result getCommon_Carousel(){
        if(logger.isInfoEnabled()){
            logger.info("【Common_Carousel_Controller—getCommon_Carousel】请求成功！");
        }
        ArrayList result = common_carousel_service.getCommon_Carousel();
        return UtilsResult.success(result,EnumException.SUCCESS);

    }
}
