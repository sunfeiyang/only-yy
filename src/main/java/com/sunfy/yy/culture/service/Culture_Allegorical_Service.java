package com.sunfy.yy.culture.service;

import com.sunfy.yy.common.utils.HttpRequest;
import com.sunfy.yy.common.utils.JsonUtils;
import com.sunfy.yy.culture.domain.Culture_Allegorical;
import com.sunfy.yy.culture.repository.Culture_Allegorical_Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Map;

@Service
public class Culture_Allegorical_Service {

    //歇后语数据库操作对象
    @Autowired
    private Culture_Allegorical_Repository culture_allegorical_repository;

    //发送http请求的对象
    HttpRequest httpRequest = new HttpRequest();

    private final static Logger logger = LoggerFactory.getLogger(Culture_Allegorical_Service.class);

    @Transactional
    //事务操作 防止多条数据插入时 有失败情况
    public ArrayList addAllegorical(String url) {
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Allegorical_Service—addAllegorical】请求成功！参数：url="+url);
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
                            logger.info("【Culture_Allegorical_Service—addAllegorical】插入数据！");
                        }
                        culture_allegorical_repository.save(this.mapToBean(mapList));
                    }else{
                        if(logger.isErrorEnabled()){
                            logger.info("【Culture_Allegorical_Service—addAllegorical】数据已存在！");
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

    /**
     * 将map中数据存入指定bean对象中并将bean对象返回
     * @param map 带有数据的map
     * @return 返回存入数据的bean对象
     */
    public Culture_Allegorical mapToBean(Map map){
        //创建要转换的bean对象
        Culture_Allegorical culture_allegorical = new Culture_Allegorical();
        /*
         * 从传入的map中获取对应的数据并将获取的内容写入对应的bean对象中
         * 【注：此处不同的bean对象都需做对应修改】
         */
        culture_allegorical.setAllegorical_zimu((String) map.get("zimu"));
        culture_allegorical.setAllegoricalanswer((String) map.get("answer"));
        culture_allegorical.setAllegoricalquestion((String) map.get("question"));
        return culture_allegorical;
    }

    /**
     * 对数据进行过滤，移除重复数据
     * @param map 待检查数据
     * @return 返回过滤结果 true：已存在 false：不存在
     */
    public boolean listFiltrate(Map map){
        String answer = (String)map.get("answer");
        String question = (String)map.get("question");
        //根据获得到的人名和对应的内容进行过滤，判断内容是否存在，存在返回true，否则返回false
        ArrayList list = (ArrayList) culture_allegorical_repository.findByAllegoricalquestionAndAllegoricalanswer(question,answer);
        if(list != null && list.size() > 0){
            return true;
        }
        return false;
    }

}
