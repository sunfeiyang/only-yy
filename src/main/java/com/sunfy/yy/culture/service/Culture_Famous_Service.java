package com.sunfy.yy.culture.service;

import com.sunfy.yy.culture.domain.Culture_Famous;
import com.sunfy.yy.culture.repository.Culture_Famous_Repository;
import com.sunfy.yy.common.utils.HttpRequest;
import com.sunfy.yy.common.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Map;

@Service
public class Culture_Famous_Service {

    //名人名言数据库操作对象
    @Autowired
    private Culture_Famous_Repository culture_famous_repository;

    //发送http请求的对象
    HttpRequest httpRequest = new HttpRequest();

    private final static Logger logger = LoggerFactory.getLogger(Culture_Famous_Service.class);

    @Transactional
    //事务操作 防止多条数据插入时 有失败情况
    public ArrayList addFamous(String url) {
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Famous_ServiceImpl—addFamous】请求成功！参数：url="+url);
        }
        //请求地址
        //String url ="https://api.avatardata.cn/MingRenMingYan/LookUp?key=71f8e8cf64f3428b8fd8d238598aa3d3&keyword=天才&page=1&rows=5";
        //url += "&keyword="+keyword;
        System.out.println("数据请求结果为：");
        System.out.println(httpRequest.get(url));
        String jsonResult = httpRequest.get(url);
        JsonUtils jsonUtils = new JsonUtils();
        Map map = null;
        try {
            map = jsonUtils.toMap(jsonResult);
            System.out.println(map.get("total"));
            Integer total = (Integer) map.get("total");
            ArrayList list = (ArrayList) map.get("result");
            if(list != null && list.size() > 0){
                for (int i = 0; i < list.size(); i++) {
                    Map mapList = (Map) list.get(i);
                    //将数据存入数据库
                    if(!this.listFiltrate(mapList)){
                        culture_famous_repository.save(this.mapToBean(mapList));
                    }else{
                        System.out.println("数据已存在——》"+mapList.toString());
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
    public Culture_Famous mapToBean(Map map){
        //创建要转换的bean对象
        Culture_Famous culture_famous = new Culture_Famous();
        /*
         * 从传入的map中获取对应的数据并将获取的内容写入对应的bean对象中
         * 【注：此处不同的bean对象都需做对应修改】
         */
        culture_famous.setFamous_name((String) map.get("famous_name"));
        culture_famous.setFamous_saying((String) map.get("famous_saying"));
        return culture_famous;
    }

    /**
     * 对数据进行过滤，移除重复数据
     * @param map 待检查数据
     * @return 返回过滤结果 true：已存在 false：不存在
     */
    public boolean listFiltrate(Map map){
//        ArrayList list = culture_famous_repository.findByFamous_name((String) map.get("famous_name"));
//        if(list == null || list.size() <= 0){
//            return true;
//        }
        return false;
    }
}
