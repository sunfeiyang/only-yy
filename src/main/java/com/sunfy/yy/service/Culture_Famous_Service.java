package com.sunfy.yy.service;

import com.sunfy.yy.domain.Culture_Famous;
import com.sunfy.yy.domain.Result;
import com.sunfy.yy.repository.Culture_Famous_Repository;
import com.sunfy.yy.utils.HttpRequest;
import com.sunfy.yy.utils.JsonUtils;
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
    public Result<Culture_Famous> addFamous(String url) {
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
            System.out.println("total-----------"+total);
            ArrayList list = (ArrayList) map.get("result");
            for (int i = 0; i < list.size(); i++) {
                Map mapList = (Map) list.get(i);
                String famous_name = (String) mapList.get("famous_name");
                String famous_saying = (String) mapList.get("famous_saying");
                System.out.println("famous_name===:"+famous_name);
                System.out.println("famous_saying===:"+famous_saying);
                Culture_Famous culture_famous = new Culture_Famous();
                culture_famous.setFamous_name(famous_name);
                culture_famous.setFamous_saying(famous_saying);
                System.out.println(culture_famous.toString());
                culture_famous_repository.save(culture_famous);
            }
            System.out.println("数据请求结束！");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
