package com.sunfy.yy.movie.controller;

import com.sunfy.yy.common.domain.Result;
import com.sunfy.yy.common.utils.UtilsAboutController;
import com.sunfy.yy.movie.service.Movie_Details_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * 电影详情控制器
 */
@RestController
public class Movie_Details_Controller {

    private static final Logger logger = LoggerFactory.getLogger(Movie_List_Controller.class);

    @Autowired
    Movie_Details_Service movie_details_service;

    @GetMapping(value = "subject/{subjectID}")
    public Result setSubject(@PathVariable("subjectID") Integer subjectID){
        if(logger.isInfoEnabled()){
            logger.info("【Movie_Details_Controller—setSubject】请求成功！");
        }
        ArrayList result = movie_details_service.setSubjectDetails(subjectID);
        return UtilsAboutController.setResult(result);
    }

    @GetMapping(value = "subject/tags/{subjectID}")
    public void setTags(@PathVariable("subjectID") Integer subjectID){
        if(logger.isInfoEnabled()){
            logger.info("【Movie_Details_Controller—setTags】请求成功！");
        }
        movie_details_service.setTags_url(subjectID+"");
    }

    @GetMapping(value = "subject/comments/{subjectID}")
    public void setComments(@PathVariable("subjectID") Integer subjectID){
        if(logger.isInfoEnabled()){
            logger.info("【Movie_Details_Controller—setComments】请求成功！");
        }
        movie_details_service.setComments_url(subjectID+"");
    }

    @GetMapping(value = "subject/reviews/{subjectID}")
    public void setReviews(@PathVariable("subjectID") Integer subjectID){
        if(logger.isInfoEnabled()){
            logger.info("【Movie_Details_Controller—setReviews】请求成功！");
        }
        movie_details_service.setReviews_url(subjectID+"");
    }

    @GetMapping(value = "subject/photos/{subjectID}")
    public void setPhotos(@PathVariable("subjectID") Integer subjectID){
        if(logger.isInfoEnabled()){
            logger.info("【Movie_Details_Controller—setPhotos】请求成功！");
        }
        movie_details_service.setPhotos_url(subjectID+"");
    }
}
