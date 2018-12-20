package com.sunfy.yy.movie.service.Impl;

import com.sunfy.yy.common.enums.EnumRepositoryType;
import com.sunfy.yy.movie.domain.Movie_In_Theaters;
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
    public ArrayList getInTheaters(String url) {
        if(logger.isInfoEnabled()){
            logger.info("【Movie_List_ServiceImpl—getInTheaters】请求成功！参数：url="+url);
        }
        return setMovie(url, EnumRepositoryType.M_IN_THEATERS.getRepositoryType());
    }

    /**
     * 将map中数据存入指定bean对象中并将bean对象返回
     * @param map 带有数据的map
     * @return 返回存入数据的bean对象
     */
    public static Movie_In_Theaters mapToBean(Map map){
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
        //movie_in_theaters.setSubject_hotshowalt(map.get("hotshowalt").toString());
        movie_in_theaters.setSubject_durations(map.get("durations").toString());
        movie_in_theaters.setSubject_mainland_pubdate(map.get("mainland_pubdate").toString());
        movie_in_theaters.setSubject_has_video(map.get("has_video").toString());
        movie_in_theaters.setSubject_images(map.get("images").toString());
        movie_in_theaters.setSubject_alt(map.get("alt").toString());
        movie_in_theaters.setSubject_total(map.get("subject_total").toString());
        return movie_in_theaters;
    }

    @Override
    public ArrayList getComingSoon(String url) {
        if(logger.isInfoEnabled()){
            logger.info("【Movie_List_ServiceImpl—getComingSoon】请求成功！参数：url="+url);
        }
        return null;
    }

    @Override
    public ArrayList getUsBox(String url) {
        if(logger.isInfoEnabled()){
            logger.info("【Movie_List_ServiceImpl—getUsBox】请求成功！参数：url="+url);
        }
        return null;
    }

    @Override
    public ArrayList getWeekly(String url) {
        if(logger.isInfoEnabled()){
            logger.info("【Movie_List_ServiceImpl—getWeekly】请求成功！参数：url="+url);
        }
        return null;
    }

    @Override
    public ArrayList getTop250(String url) {
        if(logger.isInfoEnabled()){
            logger.info("【Movie_List_ServiceImpl—getTop250】请求成功！参数：url="+url);
        }
        return null;
    }

    @Override
    public ArrayList getNewMovies(String url) {
        if(logger.isInfoEnabled()){
            logger.info("【Movie_List_ServiceImpl—getNewMovies】请求成功！参数：url="+url);
        }
        return null;
    }
}
