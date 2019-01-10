package com.sunfy.yy.movie.service.Impl;

import com.sunfy.yy.common.enums.EnumRepositoryType;
import com.sunfy.yy.common.utils.HttpRequest;
import com.sunfy.yy.common.utils.JsonUtils;
import com.sunfy.yy.movie.domain.*;
import com.sunfy.yy.movie.repository.*;
import com.sunfy.yy.movie.service.Movie_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Map;

public class Movie_ServiceImpl implements Movie_Service {

    private static final Logger logger = LoggerFactory.getLogger(Movie_ServiceImpl.class);

    //正在热映数据库操作对象
    @Autowired
    private Movie_In_Theaters_Repository movie_in_theaters_repository;

    //即将上映数据库操作对象
    @Autowired
    private Movie_Coming_Soon_Repository movie_coming_soon_repository;

    // 新片榜
    @Autowired
    private Movie_New_Movies_Repository movie_new_movies_repository;

    // Top
    @Autowired
    private Movie_Top250_Repository movie_top250_repository;

    // Weekly
    @Autowired
    private Movie_Weekly_Repository movie_weekly_repository;

    // 北美票房榜
    @Autowired
    private Movie_Us_Box_Repository movie_us_box_repository;

    @Override
    public ArrayList setMovie(String url, String repositoryType, Boolean isDel) {
        if (logger.isInfoEnabled()) {
            logger.info("【Movie_ServiceImpl—setMovie】请求成功！参数：url=" + url);
        }
        //定义返回对象
        ArrayList result_list = new ArrayList();
        //数据请求结果
        String jsonResult = HttpRequest.get(url);
        JsonUtils jsonUtils = new JsonUtils();
        Map map = null;
        try {
            //当网络异常时，获取数据为null，此时随机从现有数据中随机生成一条返回
            if (jsonResult == "" || jsonResult == null) {
//            throw new ExceptionCulture(EnumCultureException.NETWORKANOMALY);
            } else {
                map = jsonUtils.toMap(jsonResult);
                ArrayList list = (ArrayList) map.get("subjects");
                String total = map.get("total") + "";
                String date = map.get("date") + "";
                if (list != null && list.size() > 0) {
                    // 数据删除
                    this.delRepositoryTypeResult(repositoryType,isDel);
                    for (int i = 0; i < list.size(); i++) {
                        Map mapList = (Map) list.get(i);
                        //将数据存入数据库
                        mapList.put("subject_total", total);
                        mapList.put("date", date);
                        result_list.add(getRepositoryTypeResult(mapList, repositoryType));
                    }
                }
            }
            return result_list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据不同的数据库请求对象，将数据写入对应的数据库
     *
     * @param mapList        待写入数据数据
     * @param repositoryType 数据库请求对象类型
     * @return Object
     */
    public Object getRepositoryTypeResult(Map mapList, String repositoryType) {
        //定义返回对象
        Object obj = null;
        //根据mapList是有为空，空则随机返回一条，非空则尝试写入数据库【为空主要是因为调用的接口地址异常，今天访问数达到上限导致】
        if (mapList != null && !mapList.isEmpty()) {
            //此处需要动态修改【每次插入数据前根据设置的唯一性标识检查数据是否存在，存在则直接返回】
            //数据是否存在的标识
            Boolean dataIsHave = false;
            if (repositoryType.equals(EnumRepositoryType.M_IN_THEATERS.getRepositoryType())) {
                String subjectid = (String) mapList.get("id");
                Movie_In_Theaters movie_in_theaters = movie_in_theaters_repository.findBySubjectid(subjectid);
                if (movie_in_theaters != null) {
                    dataIsHave = true;
                    obj = movie_in_theaters;
                } else {
                    obj = movie_in_theaters_repository.save(Movie_List_ServiceImpl.mapToBean_In_Theaters(mapList));
                }
            } else if (repositoryType.equals(EnumRepositoryType.M_COMINGSOON.getRepositoryType())) {
                String subjectid = (String) mapList.get("id");
                Movie_Coming_Soon movie_coming_soon = movie_coming_soon_repository.findBySubjectid(subjectid);
                if (movie_coming_soon != null) {
                    dataIsHave = true;
                    obj = movie_coming_soon;
                } else {
                    obj = movie_coming_soon_repository.save(Movie_List_ServiceImpl.mapToBean_Coming_Soon(mapList));
                }
            } else if (repositoryType.equals(EnumRepositoryType.M_NEW_MOVIES.getRepositoryType())) {
                String subjectid = (String) mapList.get("id");
                Movie_New_Movies movie_new_movies = movie_new_movies_repository.findBySubjectid(subjectid);
                if (movie_new_movies != null) {
                    dataIsHave = true;
                    obj = movie_new_movies;
                } else {
                    obj = movie_new_movies_repository.save(Movie_List_ServiceImpl.mapToBean_New_Movies(mapList));
                }
            } else if (repositoryType.equals(EnumRepositoryType.M_TOP250.getRepositoryType())) {
                String subjectid = (String) mapList.get("id");
                Movie_Top250 movie_top250 = movie_top250_repository.findBySubjectid(subjectid);
                if (movie_top250 != null) {
                    dataIsHave = true;
                    obj = movie_top250;
                } else {
                    obj = movie_top250_repository.save(Movie_List_ServiceImpl.mapToBean_Top250(mapList));
                }
            } else if (repositoryType.equals(EnumRepositoryType.M_WEEKLY.getRepositoryType())) {
                Map mapList_subjectid = (Map) mapList.get("subject");
                String subjectid = mapList_subjectid.get("id") + "";
                Movie_Weekly movie_weekly = movie_weekly_repository.findBySubjectid(subjectid);
                if (movie_weekly != null) {
                    dataIsHave = true;
                    obj = movie_weekly;
                } else {
                    obj = movie_weekly_repository.save(Movie_List_ServiceImpl.mapToBean_Weekly(mapList));
                }
            } else if (repositoryType.equals(EnumRepositoryType.M_USBOX.getRepositoryType())) {
                Map map_subject = (Map) mapList.get("subject");
                Movie_Us_Box movie_us_box = movie_us_box_repository.findBySubjectid(map_subject.get("id").toString());
                if (movie_us_box != null) {
                    dataIsHave = true;
                    obj = movie_us_box;
                } else {
                    obj = movie_us_box_repository.save(Movie_List_ServiceImpl.mapToBean_Us_Box(mapList));
                }
            }
            //控制台数据标识
            if (dataIsHave) {
                if (logger.isInfoEnabled()) {
                    logger.info("【Movie_ServiceImpl—getRepositoryTypeResult】数据已存在！类型为：" + repositoryType);
                }
            } else {
                if (logger.isInfoEnabled()) {
                    logger.info("【Movie_ServiceImpl—getRepositoryTypeResult】插入数据！类型为：" + repositoryType);
                }
            }
        }
        return obj;
    }

    /**
     * 根据不同的数据库请求对象，进行数据删除
     *
     * @param repositoryType 数据库请求对象类型
     * @return Object
     */
    public void delRepositoryTypeResult(String repositoryType,Boolean isDel) {
        //此处需要动态修改【根据传入的数据库类型判断要执行的数据库对象，
        // 并根据EnumRepositoryType中设置的清空数据库的状态来判断是否执行清空数据原有数据】
        if (repositoryType.equals(EnumRepositoryType.M_IN_THEATERS.getRepositoryType())
                && isDel) {
            movie_in_theaters_repository.deleteAll();
        } else if (repositoryType.equals(EnumRepositoryType.M_COMINGSOON.getRepositoryType())
                && isDel) {
            movie_coming_soon_repository.deleteAll();
        } else if (repositoryType.equals(EnumRepositoryType.M_NEW_MOVIES.getRepositoryType())
                && isDel) {
            movie_new_movies_repository.deleteAll();
        } else if (repositoryType.equals(EnumRepositoryType.M_TOP250.getRepositoryType())
                && isDel) {
            movie_top250_repository.deleteAll();
        } else if (repositoryType.equals(EnumRepositoryType.M_WEEKLY.getRepositoryType())
                && isDel) {
            movie_weekly_repository.deleteAll();
        } else if (repositoryType.equals(EnumRepositoryType.M_USBOX.getRepositoryType())
                && isDel) {
            movie_us_box_repository.deleteAll();
        }
        //控制台输出结果
        if (logger.isInfoEnabled() && isDel) {
            logger.info("【Movie_ServiceImpl—delRepositoryTypeResult】数据已清空！类型为：" + repositoryType);
        }
    }
}
