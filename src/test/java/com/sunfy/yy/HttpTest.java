package com.sunfy.yy;

import com.sunfy.yy.domain.Culture_Famous;
import com.sunfy.yy.repository.Culture_Famous_Repository;
import com.sunfy.yy.utils.HttpRequest;
import com.sunfy.yy.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Map;

public class HttpTest {

    @Autowired
    public Culture_Famous_Repository culture_famous_repository;

    public static void main(String[] args) throws Exception {
        Culture_Famous culture_famous = new Culture_Famous();
        HttpRequest httpRequest = new HttpRequest();
        //请求地址
        String url = "https://api.avatardata.cn/MingRenMingYan/LookUp?key=71f8e8cf64f3428b8fd8d238598aa3d3&keyword=天才&page=1&rows=5";
        System.out.println("数据请求结果为：");
        System.out.println(httpRequest.get(url));
        String jsonResult = httpRequest.get(url);
        JsonUtils jsonUtils = new JsonUtils();
        Map map = jsonUtils.toMap(jsonResult);
        System.out.println(map.get("total"));
        Integer total = (Integer) map.get("total");
//        System.out.println("total-----------"+total);
        ArrayList list = (ArrayList) map.get("result");
        for (int i = 0; i < list.size(); i++) {
            Map mapList = (Map) list.get(i);
            String famous_name = (String) mapList.get("famous_name");
            String famous_saying = (String) mapList.get("famous_saying");
            System.out.println("famous_name===:"+famous_name);
            System.out.println("famous_saying===:"+famous_saying);
            culture_famous.setFamous_name(famous_name);
            culture_famous.setFamous_saying(famous_saying);
            //culture_famous_repository.save(culture_famous);
        }
        System.out.println("数据请求结束！");
    }
}
