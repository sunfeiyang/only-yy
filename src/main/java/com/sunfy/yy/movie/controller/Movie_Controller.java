package com.sunfy.yy.movie.controller;

import com.sunfy.yy.common.enums.EnumRepositoryType;
import com.sunfy.yy.common.utils.UtilsDate;
import com.sunfy.yy.movie.domain.Movie_Coming_Soon;
import com.sunfy.yy.movie.domain.Movie_In_Theaters;
import com.sunfy.yy.movie.service.Movie_Details_Service;
import com.sunfy.yy.movie.service.Movie_List_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 影视资讯定时任务
 */
@Controller
public class Movie_Controller {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private Movie_Details_Service movie_details_service;

    @Autowired
    private Movie_List_Service movie_list_service;

    private static final Logger logger = LoggerFactory.getLogger(Movie_Controller.class);

    // Top250开始次数
    int top250Num = 0;
    int top250MaxNum = 250;
    Boolean top250IsPrint = true;

    // 正在热映开始次数
    int inTheatersNum = 0;
    int inTheatersMaxNum = 9999;
    Boolean InTheatersIsPrint = true;
    ArrayList inTheatersResult = null;

    // 即将热映开始次数
    int comingSoonNum = 0;
    int comingSoonMaxNum = 9999;
    Boolean comingSoonIsPrint = true;
    ArrayList comingSoonResult = null;

    // 影视详情开始
    int subjectNum = 0;
    Boolean subjectIsPrint = true;
    List subjectRows = null;

    // 影视剧照标签
    int subject_PhotoAndTagsNum = 0;
    Boolean subject_PhotoAndTagsIsPrint = true;
    List subject_PhotoAndTagsRows = null;

    // 任务执行开始时间
    Date startDate = null;

    /**
     * Top250（定时任务）
     * @return
     */
//    @Scheduled(cron = "1 * 20 * * *")
    @Async
    public void setMovie_Top250(){
        if(logger.isInfoEnabled() && top250IsPrint){
            logger.info("【Movie_Controller—setMovie_Top250】请求成功！");
        }
        Integer count = 50;
        Integer start = 0;
        start = top250Num * count;
        top250Num++;

        if(top250Num == 1){
            startDate = new Date();
        }
        Date nowDate = new Date();
        long days = UtilsDate.getDays(startDate,nowDate);
        long times = UtilsDate.getHours(startDate,nowDate);
        long minute = UtilsDate.getMinute(startDate,nowDate);
//        System.out.println("相差的天数--"+days);
//        System.out.println("相差的小时--"+times);
//        System.out.println("相差的分钟--"+minute);
        // 设置固定时间间隔后重置数据，重新获取数据
        if(times > 24){
            top250Num = 0;
            start = 0;
            top250IsPrint = true;
        }
        // 当数据获取达到上限后设置不再执行，且输出任务执行结束后本次不再输出
        if(start >= top250MaxNum && top250IsPrint){
            logger.info("【[Top250]任务执行结束】共执行["+(top250Num - 1)+"]次,获取【"+start+"】条数据！");
            top250IsPrint = false;
        }else if(start < top250MaxNum){
            ArrayList result = movie_list_service.setTop250(count,start, EnumRepositoryType.M_TOP250.getDel());
            logger.info("【[Top250]任务执行中。。。】第["+top250Num+"]次执行,获取第【"+start+"】条后的【"+count+"】条数据！");
        }
    }

    /**
     * 正在热映（定时任务）
     * @return
     */
    @Scheduled(cron = "0 10 0-8 * * *")
    @Async
    public void setMovie_InTheaters(){
        if(logger.isInfoEnabled() && InTheatersIsPrint){
            logger.info("【Movie_Controller—setMovie_InTheaters】请求成功！");
        }
        Integer count = 50;
        Integer start = 0;
        start = inTheatersNum * count;
        inTheatersNum++;

        Boolean isDel = EnumRepositoryType.M_IN_THEATERS.getDel();
        if(inTheatersNum == 1){
            startDate = new Date();
        }else{
            isDel = false;
        }
        Date nowDate = new Date();
        long days = UtilsDate.getDays(startDate,nowDate);
        long times = UtilsDate.getHours(startDate,nowDate);
        // 设置固定时间间隔后重置数据，重新获取数据
        if(times > 24){
            inTheatersNum = 0;
            start = 0;
            InTheatersIsPrint = true;
        }
        // 第一次执行后数据保存在result中 当第二次再次执行时从中获取总的条数
        if(inTheatersNum == 2 && inTheatersResult != null){
            // 从数据中获取对应的数据总数
            Movie_In_Theaters movie_in_theaters = (Movie_In_Theaters) inTheatersResult.get(0);
            inTheatersMaxNum = Integer.parseInt(movie_in_theaters.getSubject_total());
        }

        // 当数据获取达到上限后设置不再执行，且输出任务执行结束后本次不再输出
        if(start >= inTheatersMaxNum && InTheatersIsPrint){
            logger.info("【[正在热映]任务执行结束】共执行["+(inTheatersNum - 1)+"]次,获取【"+inTheatersMaxNum+"】条数据！");
            InTheatersIsPrint = false;
        }else if(start < inTheatersMaxNum){
            inTheatersResult = movie_list_service.setInTheaters(count,start, isDel);
            logger.info("【[正在热映]任务执行中。。。】第["+inTheatersNum+"]次执行,获取第【"+start+"】条后的【"+count+"】条数据！");
        }

    }

    /**
     * 即将热映（定时任务）
     * @return
     */
    @Scheduled(cron = "0 15 0-8 * * *")
    @Async
    public void setMovie_ComingSoon(){
        if(logger.isInfoEnabled() && comingSoonIsPrint){
            logger.info("【Movie_Controller—setMovie_ComingSoon】请求成功！");
        }
        Integer count = 50;
        Integer start = 0;
        start = comingSoonNum * count;
        comingSoonNum++;

        Boolean isDel = EnumRepositoryType.M_IN_THEATERS.getDel();
        if(comingSoonNum == 1){
            startDate = new Date();
        }else{
            isDel = false;
        }
        Date nowDate = new Date();
        long days = UtilsDate.getDays(startDate,nowDate);
        long times = UtilsDate.getHours(startDate,nowDate);
        // 设置固定时间间隔后重置数据，重新获取数据
        if(times > 24){
            comingSoonNum = 0;
            start = 0;
            comingSoonIsPrint = true;
        }
        // 第一次执行后数据保存在result中 当第二次再次执行时从中获取总的条数
        if(comingSoonNum == 2 && comingSoonResult != null){
            // 从数据中获取对应的数据总数
            Movie_Coming_Soon movie_coming_soon = (Movie_Coming_Soon) comingSoonResult.get(0);
            comingSoonMaxNum = Integer.parseInt(movie_coming_soon.getSubject_total());
        }

        // 当数据获取达到上限后设置不再执行，且输出任务执行结束后本次不再输出
        if(start >= comingSoonMaxNum && comingSoonIsPrint){
            logger.info("【[即将热映]任务执行结束】共执行["+(comingSoonNum - 1)+"]次,获取【"+comingSoonMaxNum+"】条数据！");
            comingSoonIsPrint = false;
        }else if(start < comingSoonMaxNum){
            comingSoonResult = movie_list_service.setComingSoon(count,start, isDel);
            logger.info("【[即将热映]任务执行中。。。】第["+comingSoonNum+"]次执行,获取第【"+start+"】条后的【"+count+"】条数据！");
        }

    }

    /**
     * 新片榜（定时任务）
     * @return
     */
    @Scheduled(cron = "0 17 0-8 * * *")
    @Async
    public void setMovie_NewMovies(){
        if(logger.isInfoEnabled()){
            logger.info("【Movie_Controller—setMovie_NewMovies】请求成功！");
        }
        ArrayList result_new_movies = movie_list_service.setNewMovies(EnumRepositoryType.M_NEW_MOVIES.getDel());
        logger.info("【[新片榜]任务执行结束】共执行[1]次,获取【"+result_new_movies.size()+"】条数据！");

    }

    /**
     * 欧美票房榜（定时任务）
     * @return
     */
    @Scheduled(cron = "0 18 0-8 * * *")
    @Async
    public void setMovie_UsBox(){
        if(logger.isInfoEnabled()){
            logger.info("【Movie_Controller—setMovie_UsBox】请求成功！");
        }
        ArrayList result_UsBox = movie_list_service.setUsBox(EnumRepositoryType.M_USBOX.getDel());
        logger.info("【[欧美票房榜]任务执行结束】共执行[1]次,获取【"+result_UsBox.size()+"】条数据！");

    }

    /**
     * 一周口碑榜（定时任务）
     * @return
     */
    @Scheduled(cron = "0 19 0-8 * * *")
    @Async
    public void setMovie_Weekly(){
        if(logger.isInfoEnabled()){
            logger.info("【Movie_Controller—setMovie_Weekly】请求成功！");
        }
        ArrayList result_Weekly = movie_list_service.setWeekly(EnumRepositoryType.M_WEEKLY.getDel());
        logger.info("【[一周口碑榜]任务执行结束】共执行[1]次,获取【"+result_Weekly.size()+"】条数据！");

    }

    /**
     * 查询视图写入影片详情（定时任务）
     * @return
     */
    @Scheduled(cron = "0 0/2 * * * *")
    @Async
    public void setMovie_Subject(){
        if(logger.isInfoEnabled() && subjectIsPrint){
            logger.info("【Movie_Controller—setMovie_Subject】请求成功！");
        }

        if(subjectNum == 0){
            startDate = new Date();
            // 使用query自定义查询数据
            Query query = em.createNativeQuery("select SUBJECT_ID from view_movie_subjectid group by SUBJECT_ID");
            subjectRows = query.getResultList();
        }
        Date nowDate = new Date();
        long days = UtilsDate.getDays(startDate,nowDate);
        long times = UtilsDate.getHours(startDate,nowDate);
        // 设置固定时间间隔后重置数据，重新获取数据
        if(times > 24){
            subjectNum = 0;
            subjectIsPrint = true;
            startDate = new Date();
        }

//        subjectRows.get(subjectNum);
        // 当数据获取达到上限后设置不再执行，且输出任务执行结束后本次不再输出
        if(subjectNum >= subjectRows.size() && subjectIsPrint){
            logger.info("【[影视详情]任务执行结束】共执行["+(subjectNum+1)+"]次,获取【"+(subjectRows.size()+1)+"】条数据！");
            subjectIsPrint = false;
        }else if(subjectNum < subjectRows.size()){
            String subjectID = subjectRows.get(subjectNum) + "";
            movie_details_service.setSubjectDetails(subjectID);
//            movie_details_service.setPhotos_url(subjectID);
            movie_details_service.setReviews_url(subjectID);
            movie_details_service.setComments_url(subjectID);
//            movie_details_service.setTags_url(subjectID);
            logger.info("【[影视详情]任务执行中。。。】第["+(subjectNum+1)+"]次执行,获取【subject="+subjectID+"】数据完成！");
        }
        // 循环执行时自增
        subjectNum++;

    }

    /**
     * 查询视图写入影片标签和剧照（定时任务）
     * @return
     */
    @Scheduled(cron = "0 1/2 * * * *")
    @Async
    public void setMovie_PhotoAndTags(){
        if(logger.isInfoEnabled() && subject_PhotoAndTagsIsPrint){
            logger.info("【Movie_Controller—setMovie_PhotoAndTags】请求成功！");
        }

        if(subject_PhotoAndTagsNum == 0){
            startDate = new Date();
            // 使用query自定义查询数据
            Query query = em.createNativeQuery("select SUBJECT_ID from view_movie_subjectid group by SUBJECT_ID");
            subject_PhotoAndTagsRows = query.getResultList();
        }
        Date nowDate = new Date();
        long days = UtilsDate.getDays(startDate,nowDate);
        long times = UtilsDate.getHours(startDate,nowDate);
        // 设置固定时间间隔后重置数据，重新获取数据
        if(times > 24){
            subject_PhotoAndTagsNum = 0;
            subject_PhotoAndTagsIsPrint = true;
            startDate = new Date();
        }

//        subjectRows.get(subjectNum);
        // 当数据获取达到上限后设置不再执行，且输出任务执行结束后本次不再输出
        if(subject_PhotoAndTagsNum >= subject_PhotoAndTagsRows.size() && subject_PhotoAndTagsIsPrint){
            logger.info("【[标签和剧照]任务执行结束】共执行["+(subject_PhotoAndTagsNum+1)+"]次,获取【"+(subject_PhotoAndTagsRows.size()+1)+"】条数据！");
            subject_PhotoAndTagsIsPrint = false;
        }else if(subject_PhotoAndTagsNum < subject_PhotoAndTagsRows.size()){
            String subjectID = subject_PhotoAndTagsRows.get(subject_PhotoAndTagsNum) + "";
            movie_details_service.setPhotos_url(subjectID);
            movie_details_service.setTags_url(subjectID);
            logger.info("【[标签和剧照]任务执行中。。。】第["+(subject_PhotoAndTagsNum+1)+"]次执行,获取【subject="+subjectID+"】数据完成！");
        }
        // 循环执行时自增
        subject_PhotoAndTagsNum++;

    }



}
