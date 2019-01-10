package com.sunfy.yy.movie.service.Impl;

import com.sunfy.yy.common.enums.EnumApi;
import com.sunfy.yy.common.enums.EnumRepositoryType;
import com.sunfy.yy.movie.domain.*;
import com.sunfy.yy.movie.service.Movie_List_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class Movie_List_ServiceImpl extends Movie_ServiceImpl implements Movie_List_Service {

    private static final Logger logger = LoggerFactory.getLogger(Movie_List_ServiceImpl.class);

    @Override
    public ArrayList setInTheaters(Integer count,Integer start,Boolean idDel) {
        if(logger.isInfoEnabled()){
            logger.info("【Movie_List_ServiceImpl—getInTheaters】请求成功！");
        }
        return setMovie(EnumApi.M_IN_THEATERS.getURL()+"?count="+count+"&start="+start,
                EnumRepositoryType.M_IN_THEATERS.getRepositoryType(),
                idDel);
    }

    @Override
    public ArrayList setComingSoon(Integer count,Integer start,Boolean idDel) {
        if(logger.isInfoEnabled()){
            logger.info("【Movie_List_ServiceImpl—getComingSoon】请求成功！");
        }
        return setMovie(EnumApi.M_COMINGSOON.getURL()+"?count="+count+"&start="+start,
                EnumRepositoryType.M_COMINGSOON.getRepositoryType(),
                idDel);
    }

    @Override
    public ArrayList setUsBox(Boolean idDel) {
        if(logger.isInfoEnabled()){
            logger.info("【Movie_List_ServiceImpl—getUsBox】请求成功！");
        }
        return setMovie(EnumApi.M_USBOX.getURL(),
                EnumRepositoryType.M_USBOX.getRepositoryType(),
                idDel);
    }

    @Override
    public ArrayList setWeekly(Boolean idDel) {
        if(logger.isInfoEnabled()){
            logger.info("【Movie_List_ServiceImpl—getWeekly】请求成功！");
        }
        return setMovie(EnumApi.M_WEEKLY.getURL(),
                EnumRepositoryType.M_WEEKLY.getRepositoryType(),
                idDel);
    }

    @Override
    public ArrayList setTop250(Integer count,Integer start,Boolean idDel) {
        if(logger.isInfoEnabled()){
            logger.info("【Movie_List_ServiceImpl—getTop250】请求成功！");
        }
        return setMovie(EnumApi.M_TOP250.getURL()+"?count="+count+"&start="+start,
                EnumRepositoryType.M_TOP250.getRepositoryType(),
                idDel);
    }

    @Override
    public ArrayList setNewMovies(Boolean idDel) {
        if(logger.isInfoEnabled()){
            logger.info("【Movie_List_ServiceImpl—getNewMovies】请求成功！");
        }
        return setMovie(EnumApi.M_NEW_MOVIES.getURL(),
                EnumRepositoryType.M_NEW_MOVIES.getRepositoryType(),
                idDel);
    }

    /**
     * 将map中数据存入指定bean对象中并将bean对象返回
     * @param map 带有数据的map
     * @return 返回存入数据的bean对象
     */
    public static Movie_In_Theaters mapToBean_In_Theaters(Map map){
        //创建要转换的bean对象
        Movie_In_Theaters movie_in_theaters = new Movie_In_Theaters();
        /*
         * 从传入的map中获取对应的数据并将获取的内容写入对应的bean对象中
         * 【注：此处不同的bean对象都需做对应修改】
         */
        movie_in_theaters.setSubjectid(map.get("id").toString());
        movie_in_theaters.setSubject_title(map.get("title").toString());
        movie_in_theaters.setSubject_original_title(map.get("original_title").toString());
        movie_in_theaters.setSubject_genres(map.get("genres").toString());
        Map ratingMap = (Map) map.get("rating");
        movie_in_theaters.setSubject_rating_max(ratingMap.get("max").toString());
        movie_in_theaters.setSubject_rating_average(ratingMap.get("average").toString());
        movie_in_theaters.setSubject_rating_stars(ratingMap.get("stars").toString());
        movie_in_theaters.setSubject_rating_min(ratingMap.get("min").toString());
        movie_in_theaters.setSubject_collect_count(map.get("collect_count").toString());
        movie_in_theaters.setSubject_subtype(map.get("subtype").toString());
        movie_in_theaters.setSubject_year(map.get("year").toString());
        movie_in_theaters.setSubject_hotshowalt(map.get("hotshowalt") + "");
        movie_in_theaters.setSubject_durations(map.get("durations").toString());
        movie_in_theaters.setSubject_mainland_pubdate(map.get("mainland_pubdate").toString());
        movie_in_theaters.setSubject_has_video(map.get("has_video").toString());
        movie_in_theaters.setSubject_images(map.get("images").toString());
        movie_in_theaters.setSubject_alt(map.get("alt").toString());
        movie_in_theaters.setSubject_total(map.get("subject_total")+ "");
        return movie_in_theaters;
    }

    /**
     * 将map中数据存入指定bean对象中并将bean对象返回
     * @param map 带有数据的map
     * @return 返回存入数据的bean对象
     */
    public static Movie_New_Movies mapToBean_New_Movies(Map map){
        //创建要转换的bean对象
        Movie_New_Movies movie_new_movies = new Movie_New_Movies();
        /*
         * 从传入的map中获取对应的数据并将获取的内容写入对应的bean对象中
         * 【注：此处不同的bean对象都需做对应修改】
         */
        movie_new_movies.setSubjectid(map.get("id").toString());
        movie_new_movies.setSubject_title(map.get("title").toString());
        movie_new_movies.setSubject_original_title(map.get("original_title").toString());
        movie_new_movies.setSubject_genres(map.get("genres").toString());
        Map ratingMap = (Map) map.get("rating");
        movie_new_movies.setSubject_rating_max(ratingMap.get("max").toString());
        movie_new_movies.setSubject_rating_average(ratingMap.get("average").toString());
        movie_new_movies.setSubject_rating_stars(ratingMap.get("stars").toString());
        movie_new_movies.setSubject_rating_min(ratingMap.get("min").toString());
        movie_new_movies.setSubject_collect_count(map.get("collect_count").toString());
        movie_new_movies.setSubject_subtype(map.get("subtype").toString());
        movie_new_movies.setSubject_year(map.get("year").toString());
        movie_new_movies.setSubject_hotshowalt(map.get("hotshowalt") + "");
        movie_new_movies.setSubject_durations(map.get("durations").toString());
        movie_new_movies.setSubject_mainland_pubdate(map.get("mainland_pubdate").toString());
        movie_new_movies.setSubject_has_video(map.get("has_video").toString());
        movie_new_movies.setSubject_images(map.get("images").toString());
        movie_new_movies.setSubject_alt(map.get("alt").toString());
//        movie_in_theaters.setSubject_rank(map.get("subject_total").toString());
        return movie_new_movies;
    }

    /**
     * 将map中数据存入指定bean对象中并将bean对象返回
     * @param map 带有数据的map
     * @return 返回存入数据的bean对象
     */
    public static Movie_Top250 mapToBean_Top250(Map map){
        //创建要转换的bean对象
        Movie_Top250 movie_top250 = new Movie_Top250();
        /*
         * 从传入的map中获取对应的数据并将获取的内容写入对应的bean对象中
         * 【注：此处不同的bean对象都需做对应修改】
         */
        movie_top250.setSubjectid(map.get("id").toString());
        movie_top250.setSubject_title(map.get("title").toString());
        movie_top250.setSubject_original_title(map.get("original_title").toString());
        movie_top250.setSubject_genres(map.get("genres").toString());
        Map ratingMap = (Map) map.get("rating");
        movie_top250.setSubject_rating_max(ratingMap.get("max").toString());
        movie_top250.setSubject_rating_average(ratingMap.get("average").toString());
        movie_top250.setSubject_rating_stars(ratingMap.get("stars").toString());
        movie_top250.setSubject_rating_min(ratingMap.get("min").toString());
        movie_top250.setSubject_collect_count(map.get("collect_count").toString());
        movie_top250.setSubject_subtype(map.get("subtype").toString());
        movie_top250.setSubject_year(map.get("year").toString());
        movie_top250.setSubject_hotshowalt(map.get("hotshowalt") + "");
        movie_top250.setSubject_durations(map.get("durations").toString());
        movie_top250.setSubject_mainland_pubdate(map.get("mainland_pubdate").toString());
        movie_top250.setSubject_has_video(map.get("has_video").toString());
        movie_top250.setSubject_images(map.get("images").toString());
        movie_top250.setSubject_alt(map.get("alt").toString());
//        movie_in_theaters.setSubject_rank(map.get("subject_total").toString());
        return movie_top250;
    }

    /**
     * 将map中数据存入指定bean对象中并将bean对象返回
     * @param map 带有数据的map
     * @return 返回存入数据的bean对象
     */
    public static Movie_Us_Box mapToBean_Us_Box(Map map){
        //创建要转换的bean对象
        Movie_Us_Box movie_us_box = new Movie_Us_Box();
        /*
         * 从传入的map中获取对应的数据并将获取的内容写入对应的bean对象中
         * 【注：此处不同的bean对象都需做对应修改】
         */
        movie_us_box.setSubject_box(map.get("box")+"");
        movie_us_box.setSubject_new(map.get("new")+"");
        movie_us_box.setSubject_rank(map.get("rank")+"");
        movie_us_box.setSubject_date(map.get("date")+"");
        Map map_subject = (Map)map.get("subject");
        movie_us_box.setSubjectid(map_subject.get("id").toString());
        movie_us_box.setSubject_title(map_subject.get("title").toString());
        movie_us_box.setSubject_original_title(map_subject.get("original_title").toString());
        movie_us_box.setSubject_genres(map_subject.get("genres").toString());
        Map ratingMap = (Map) map_subject.get("rating");
        movie_us_box.setSubject_rating_max(ratingMap.get("max").toString());
        movie_us_box.setSubject_rating_average(ratingMap.get("average").toString());
        movie_us_box.setSubject_rating_stars(ratingMap.get("stars").toString());
        movie_us_box.setSubject_rating_min(ratingMap.get("min").toString());
        movie_us_box.setSubject_collect_count(map_subject.get("collect_count").toString());
        movie_us_box.setSubject_subtype(map_subject.get("subtype").toString());
        movie_us_box.setSubject_year(map_subject.get("year").toString());
        movie_us_box.setSubject_hotshowalt(map_subject.get("hotshowalt") + "");
        movie_us_box.setSubject_durations(map_subject.get("durations").toString());
        movie_us_box.setSubject_mainland_pubdate(map_subject.get("mainland_pubdate").toString());
        movie_us_box.setSubject_has_video(map_subject.get("has_video").toString());
        movie_us_box.setSubject_images(map_subject.get("images").toString());
        movie_us_box.setSubject_alt(map_subject.get("alt").toString());
//        movie_in_theaters.setSubject_rank(map.get("subject_total").toString());
        return movie_us_box;
    }

    /**
     * 将map中数据存入指定bean对象中并将bean对象返回
     * @param map 带有数据的map
     * @return 返回存入数据的bean对象
     */
    public static Movie_Weekly mapToBean_Weekly(Map map){
        //创建要转换的bean对象
        Movie_Weekly movie_weekly = new Movie_Weekly();
        /*
         * 从传入的map中获取对应的数据并将获取的内容写入对应的bean对象中
         * 【注：此处不同的bean对象都需做对应修改】
         */
        Map subject = (Map)map.get("subject");
        movie_weekly.setSubjectid(subject.get("id").toString());
        movie_weekly.setSubject_title(subject.get("title").toString());
        movie_weekly.setSubject_original_title(subject.get("original_title").toString());
        movie_weekly.setSubject_genres(subject.get("genres").toString());
        Map ratingMap = (Map) subject.get("rating");
        movie_weekly.setSubject_rating_max(ratingMap.get("max").toString());
        movie_weekly.setSubject_rating_average(ratingMap.get("average").toString());
        movie_weekly.setSubject_rating_stars(ratingMap.get("stars").toString());
        movie_weekly.setSubject_rating_min(ratingMap.get("min").toString());
        movie_weekly.setSubject_collect_count(subject.get("collect_count").toString());
        movie_weekly.setSubject_subtype(subject.get("subtype").toString());
        movie_weekly.setSubject_year(subject.get("year").toString());
        movie_weekly.setSubject_hotshowalt(subject.get("hotshowalt") + "");
        movie_weekly.setSubject_durations(subject.get("durations").toString());
        movie_weekly.setSubject_mainland_pubdate(subject.get("mainland_pubdate").toString());
        movie_weekly.setSubject_has_video(subject.get("has_video").toString());
        movie_weekly.setSubject_images(subject.get("images").toString());
        movie_weekly.setSubject_alt(subject.get("alt").toString());
        movie_weekly.setSubject_rank(map.get("rank").toString());
        movie_weekly.setSubject_delta(map.get("delta").toString());
//        movie_in_theaters.setSubject_rank(map.get("subject_total").toString());
        return movie_weekly;
    }

    /**
     * 将map中数据存入指定bean对象中并将bean对象返回
     * @param map 带有数据的map
     * @return 返回存入数据的bean对象
     */
    public static Movie_Coming_Soon mapToBean_Coming_Soon(Map map){
        //创建要转换的bean对象
        Movie_Coming_Soon movie_coming_soon = new Movie_Coming_Soon();
        /*
         * 从传入的map中获取对应的数据并将获取的内容写入对应的bean对象中
         * 【注：此处不同的bean对象都需做对应修改】
         */
        movie_coming_soon.setSubjectid(map.get("id").toString());
        movie_coming_soon.setSubject_title(map.get("title").toString());
        movie_coming_soon.setSubject_original_title(map.get("original_title").toString());
        movie_coming_soon.setSubject_genres(map.get("genres").toString());
        Map ratingMap = (Map) map.get("rating");
        movie_coming_soon.setSubject_rating_max(ratingMap.get("max").toString());
        movie_coming_soon.setSubject_rating_average(ratingMap.get("average").toString());
        movie_coming_soon.setSubject_rating_stars(ratingMap.get("stars").toString());
        movie_coming_soon.setSubject_rating_min(ratingMap.get("min").toString());
        movie_coming_soon.setSubject_collect_count(map.get("collect_count").toString());
        movie_coming_soon.setSubject_subtype(map.get("subtype").toString());
        movie_coming_soon.setSubject_year(map.get("year").toString());
        movie_coming_soon.setSubject_hotshowalt(map.get("hotshowalt") + "");
        movie_coming_soon.setSubject_durations(map.get("durations").toString());
        movie_coming_soon.setSubject_mainland_pubdate(map.get("mainland_pubdate").toString());
        movie_coming_soon.setSubject_has_video(map.get("has_video").toString());
        movie_coming_soon.setSubject_images(map.get("images").toString());
        movie_coming_soon.setSubject_alt(map.get("alt").toString());
        movie_coming_soon.setSubject_total(map.get("subject_total").toString());
        return movie_coming_soon;
    }
}
