package com.sunfy.yy.movie.controller;

import com.sunfy.yy.common.domain.Result;
import com.sunfy.yy.common.enums.EnumRepositoryType;
import com.sunfy.yy.common.utils.UtilsAboutController;
import com.sunfy.yy.movie.service.Movie_List_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * 影片列表【包括正在热映、即将上映、各种类别排行等信息】
 */
@RestController
public class Movie_List_Controller {

    private static final Logger logger = LoggerFactory.getLogger(Movie_List_Controller.class);

    @Autowired
    private Movie_List_Service movie_list_service;

    /**
     * 查询正在热映列表
     * @return Result
     */
    @GetMapping(value = "inTheaters")
    public Result getInTheaters(@RequestParam("count") Integer count,
                                @RequestParam("start") Integer start){
        if(logger.isInfoEnabled()){
            logger.info("【Movie_List_Controller—getInTheaters】请求成功！");
        }
        ArrayList result_list = movie_list_service.setInTheaters(count,start, EnumRepositoryType.M_IN_THEATERS.getDel());
        return UtilsAboutController.setResult(result_list);
    }

    /**
     * 查询即将上映列表
     * @return Result
     */
    @GetMapping(value = "comingsoon")
    public Result getComingsoon(@RequestParam("count") Integer count,
                                @RequestParam("start") Integer start){
        if(logger.isInfoEnabled()){
            logger.info("【Movie_List_Controller—getComingsoon】请求成功！");
        }
        ArrayList result_list = movie_list_service.setComingSoon(count,start, EnumRepositoryType.M_COMINGSOON.getDel());
        return UtilsAboutController.setResult(result_list);
    }

    /**
     * 查询新片榜列表
     * @return Result
     */
    @GetMapping(value = "newMovies")
    public Result getNewMovies(){
        if(logger.isInfoEnabled()){
            logger.info("【Movie_List_Controller—getNewMovies】请求成功！");
        }
        ArrayList result_list = movie_list_service.setNewMovies(EnumRepositoryType.M_NEW_MOVIES.getDel());
        return UtilsAboutController.setResult(result_list);
    }

    /**
     * 查询一周口碑榜列表
     * @return Result
     */
    @GetMapping(value = "weekly")
    public Result getWeekly(){
        if(logger.isInfoEnabled()){
            logger.info("【Movie_List_Controller—getWeekly】请求成功！");
        }
        ArrayList result_list = movie_list_service.setWeekly(EnumRepositoryType.M_WEEKLY.getDel());
        return UtilsAboutController.setResult(result_list);
    }

    /**
     * Top250榜列表
     * @return Result
     */
    @GetMapping(value = "top250")
    public Result getTop250(@RequestParam("count") Integer count,
                            @RequestParam("start") Integer start){
        if(logger.isInfoEnabled()){
            logger.info("【Movie_List_Controller—getTop250】请求成功！");
        }
        ArrayList result_list = movie_list_service.setTop250(count,start,EnumRepositoryType.M_TOP250.getDel());
        return UtilsAboutController.setResult(result_list);
    }

    /**
     * 查询北美票房榜列表
     * @return Result
     */
    @GetMapping(value = "usbox")
    public Result getUsbox(){
        if(logger.isInfoEnabled()){
            logger.info("【Movie_List_Controller—getUsbox】请求成功！");
        }
        ArrayList result_list = movie_list_service.setUsBox(EnumRepositoryType.M_USBOX.getDel());
        return UtilsAboutController.setResult(result_list);
    }

}
