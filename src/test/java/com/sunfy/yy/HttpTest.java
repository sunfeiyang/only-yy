package com.sunfy.yy;

import com.sunfy.yy.utils.HttpRequest;

public class HttpTest {

    public static void main(String[] args) {
        HttpRequest httpRequest = new HttpRequest();
        //请求地址
        String url = "https://douban.uieee.com/v2/movie/subject/26636712";
        System.out.println("数据请求结果为：");
        System.out.println(httpRequest.get(url));

    }
}
