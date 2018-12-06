package com.sunfy.yy.service.Impl;

import com.sunfy.yy.domain.Culture_Famous;
import com.sunfy.yy.domain.Result;
import com.sunfy.yy.repository.Culture_Famous_Repository;
import com.sunfy.yy.service.Culture_Famous_Service;
import com.sunfy.yy.utils.HttpRequest;
import com.sunfy.yy.utils.JsonUtils;
import com.sunfy.yy.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Map;

public class Culture_Famous_ServiceImpl implements Culture_Famous_Service {

    //名人名言数据库操作对象
    @Autowired
    private Culture_Famous_Repository culture_famous_repository;

    //发送http请求的对象
    HttpRequest httpRequest = new HttpRequest();

    private final static Logger logger = LoggerFactory.getLogger(Culture_Famous_ServiceImpl.class);

    @Override
    public Result<Culture_Famous> addFamous(String keyword) {
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Famous_ServiceImpl—addFamous】请求成功！参数：keyword="+keyword);
        }
        Culture_Famous culture_famous = new Culture_Famous();
        //请求地址
        String url ="https://api.avatardata.cn/MingRenMingYan/LookUp?key=71f8e8cf64f3428b8fd8d238598aa3d3&keyword=天才&page=1&rows=5";
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
                culture_famous.setFamous_name(famous_name);
                culture_famous.setFamous_saying(famous_saying);
                culture_famous_repository.save(culture_famous);
            }
            System.out.println("数据请求结束！");
            return ResultUtil.success(culture_famous_repository.save(culture_famous));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
