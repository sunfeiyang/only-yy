package com.sunfy.yy.culture.service;

import com.sunfy.yy.common.utils.HttpRequest;
import com.sunfy.yy.common.utils.JsonUtils;
import com.sunfy.yy.culture.repository.*;
import com.sunfy.yy.culture.utils.EnumRepositoryType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Map;

public class Culture_Service {

    //发送http请求的对象
    HttpRequest httpRequest = new HttpRequest();

    //歇后语数据库操作对象
    @Autowired
    private Culture_Allegorical_Repository culture_allegorical_repository;

    //字典数据库操作对象
    @Autowired
    private Culture_Dic_Repository culture_Dic_repository;

    //名人名言数据库操作对象
    @Autowired
    private Culture_Famous_Repository culture_famous_repository;

    //成语数据库操作对象
    @Autowired
    private Culture_Idiom_Repository culture_idiom_repository;

    //唐诗宋词数据库操作对象
    @Autowired
    private Culture_Poem_Repository culture_poem_repository;

    //历史上的今天数据库操作对象
    @Autowired
    private Culture_Today_History_Repository culture_today_history_repository;

    private final static Logger logger = LoggerFactory.getLogger(Culture_Service.class);

    /**
     * 随机生成一条
     * @param url 请求链接
     * @param repositoryType 数据库请求对象类型
     * @return ArrayList
     */
    public ArrayList addRandom(String url,String repositoryType) {
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Service—addRandom】请求成功！参数：url="+url);
        }
        //定义返回对象
        ArrayList result_list = new ArrayList();
        //数据请求结果
        String jsonResult = httpRequest.get(url);
        JsonUtils jsonUtils = new JsonUtils();
        Map map = null;
        try {
            map = jsonUtils.toMap(jsonResult);
            Map mapList = (Map) map.get("result");
            if(logger.isErrorEnabled()){
                logger.info("【Culture_Service—addAllegorical】插入数据！");
            }

            result_list.add(getRepositoryTypeResult(mapList,repositoryType));
            return result_list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 多条数据同时写入
     * @param url 请求链接
     * @param repositoryType 数据库请求对象类型
     * @return ArrayList
     */
    @Transactional
    //事务操作 防止多条数据插入时 有失败情况
    public ArrayList addList(String url,String repositoryType) {
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Service—addList】请求成功！参数：url="+url);
        }
        //定义返回对象
        ArrayList result_list = new ArrayList();

        String jsonResult = httpRequest.get(url);
        JsonUtils jsonUtils = new JsonUtils();
        Map map = null;
        try {
            map = jsonUtils.toMap(jsonResult);
            Integer total = (Integer) map.get("total");
            ArrayList list = (ArrayList) map.get("result");
            if(list != null && list.size() > 0){
                for (int i = 0; i < list.size(); i++) {
                    Map mapList = (Map) list.get(i);
                    //将数据存入数据库
                    if(logger.isErrorEnabled()){
                        logger.info("【Culture_Allegorical_Service—addAllegorical】插入数据！");
                    }
                    result_list.add(this.getRepositoryTypeResult(mapList,repositoryType));
                }
                return result_list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据不同的数据库请求对象，将数据写入对应的数据库
     * @param mapList 待写入数据数据
     * @param repositoryType 数据库请求对象类型
     * @return Object
     */
    public Object getRepositoryTypeResult(Map mapList,String repositoryType){
        //定义返回对象
        Object obj = null;
        //此处需要动态修改
        if (repositoryType.equals(EnumRepositoryType.ALLEGORICAL.getRepositoryType())){
            obj = culture_allegorical_repository.save(Culture_Allegorical_Service.mapToBean(mapList));
        }else if(repositoryType.equals(EnumRepositoryType.DIC.getRepositoryType())){
            obj = culture_Dic_repository.save(Culture_Dic_Service.mapToBean(mapList));
        }else if(repositoryType.equals(EnumRepositoryType.FAMOUS.getRepositoryType())){
            obj = culture_famous_repository.save(Culture_Famous_Service.mapToBean(mapList));
        }else if(repositoryType.equals(EnumRepositoryType.IDIOM.getRepositoryType())){
            obj = culture_idiom_repository.save(Culture_Idiom_Service.mapToBean(mapList));
        }else if(repositoryType.equals(EnumRepositoryType.POEM.getRepositoryType())){
            obj = culture_poem_repository.save(Culture_Poem_Service.mapToBean(mapList));
        }else if(repositoryType.equals(EnumRepositoryType.TODAY_HISTORY.getRepositoryType())){
            obj = culture_today_history_repository.save(Culture_Today_History_Service.mapToBean(mapList));
        }
        return obj;
    }

}
