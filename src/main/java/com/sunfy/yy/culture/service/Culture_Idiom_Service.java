package com.sunfy.yy.culture.service;

import com.sunfy.yy.common.utils.HttpRequest;
import com.sunfy.yy.common.utils.JsonUtils;
import com.sunfy.yy.culture.domain.Culture_Idiom;
import com.sunfy.yy.culture.repository.Culture_Idiom_Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Map;

@Service
public class Culture_Idiom_Service {

    //成语数据库操作对象
    @Autowired
    private Culture_Idiom_Repository culture_idiom_repository;

    //发送http请求的对象
    HttpRequest httpRequest = new HttpRequest();

    private final static Logger logger = LoggerFactory.getLogger(Culture_Idiom_Service.class);

    @Transactional
    //事务操作 防止多条数据插入时 有失败情况
    public ArrayList addIdiomList(String url) {
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Idiom_Service—addIdiomList】请求成功！参数：url="+url);
        }
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
                    String id = (String)mapList.get("id");
                    String urlDetails ="https://api.avatardata.cn/ChengYu/LookUp?key=2431b0ba7ab24c8191df893243382dc4";
                    if(!id.equals("") && id != null){
                        urlDetails += "&id="+id;
                    }
                    String jsonResultDetails = httpRequest.get(urlDetails);
                    Map mapDetails = jsonUtils.toMap(jsonResultDetails);
                    if(!this.listFiltrate((Map) mapDetails.get("result"))){
                        if(logger.isErrorEnabled()){
                            logger.info("【Culture_Idiom_Service—addIdiomList】插入数据！");
                        }
                        culture_idiom_repository.save(this.mapToBean((Map) mapDetails.get("result")));
                    }else{
                        if(logger.isErrorEnabled()){
                            logger.info("【Culture_Idiom_Service—addIdiomList】数据已存在！");
                        }
                    }
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Transactional
    //事务操作 防止多条数据插入时 有失败情况
    public ArrayList addIdiom(String url) {
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Idiom_Service—addIdiom】请求成功！参数：url="+url);
        }
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
                    if(!this.listFiltrate(mapList)){
                        if(logger.isErrorEnabled()){
                            logger.info("【Culture_Idiom_Service—addIdiom】插入数据！");
                        }
                        culture_idiom_repository.save(this.mapToBean(mapList));
                    }else{
                        if(logger.isErrorEnabled()){
                            logger.info("【Culture_Idiom_Service—addIdiom】数据已存在！");
                        }
                    }
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Transactional
    //事务操作 防止多条数据插入时 有失败情况
    public Map addIdiomRandom(String url) {
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Idiom_Service—addIdiomRandom】请求成功！参数：url="+url);
        }
        String jsonResult = httpRequest.get(url);
        JsonUtils jsonUtils = new JsonUtils();
        Map map = null;
        try {
            map = jsonUtils.toMap(jsonResult);
            Map mapList = (Map) map.get("result");
            //将数据存入数据库
            if(!this.listFiltrate(mapList)){
                if(logger.isErrorEnabled()){
                    logger.info("【Culture_Idiom_Service—addIdiomRandom】插入数据！");
                }
                culture_idiom_repository.save(this.mapToBean(mapList));
            }else{
                if(logger.isErrorEnabled()){
                    logger.info("【Culture_Idiom_Service—addIdiomRandom】数据已存在！");
                }
            }
            return mapList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将map中数据存入指定bean对象中并将bean对象返回
     * @param map 带有数据的map
     * @return 返回存入数据的bean对象
     */
    public Culture_Idiom mapToBean(Map map){
        //创建要转换的bean对象
        Culture_Idiom culture_idiom = new Culture_Idiom();
        /*
         * 从传入的map中获取对应的数据并将获取的内容写入对应的bean对象中
         * 【注：此处不同的bean对象都需做对应修改】
         */
        culture_idiom.setIdiomid((String) map.get("id"));
        culture_idiom.setIdiomname((String) map.get("name"));
        culture_idiom.setIdiom_spell((String) map.get("spell"));
        culture_idiom.setIdiom_content((String) map.get("content"));
        culture_idiom.setIdiom_derivation((String) map.get("derivation"));
        culture_idiom.setIdiom_samples((String) map.get("samples"));
        return culture_idiom;
    }

    /**
     * 对数据进行过滤，移除重复数据
     * @param map 待检查数据
     * @return 返回过滤结果 true：已存在 false：不存在
     */
    public boolean listFiltrate(Map map){
        String id = (String)map.get("id");
        //根据获得到的内容进行过滤，判断内容是否存在，存在返回true，否则返回false
        ArrayList list = (ArrayList) culture_idiom_repository.findByIdiomid(id);
        if(list != null && list.size() > 0){
            return true;
        }
        return false;
    }

}
