package com.sunfy.yy.movie.service.Impl;

import com.sunfy.yy.common.enums.EnumRepositoryType;
import com.sunfy.yy.common.utils.HttpRequest;
import com.sunfy.yy.common.utils.JsonUtils;
import com.sunfy.yy.movie.domain.Movie_In_Theaters;
import com.sunfy.yy.movie.repository.Movie_In_Theaters_Repository;
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

    @Override
    public ArrayList setMovie(String url,String repositoryType) {
        if(logger.isInfoEnabled()){
            logger.info("【Movie_ServiceImpl—setMovie】请求成功！参数：url="+url);
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
                String total = map.get("total").toString();
                if (list != null && list.size() > 0) {
                    for (int i = 0; i < list.size(); i++) {
                        Map mapList = (Map) list.get(i);
                        //将数据存入数据库
                        mapList.put("subject_total",total);
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
                    obj = movie_in_theaters_repository.save(Movie_List_ServiceImpl.mapToBean(mapList));
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
}
