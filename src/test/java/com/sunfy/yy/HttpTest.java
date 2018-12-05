package com.sunfy.yy;

import com.sunfy.yy.utils.HttpRequest;

public class HttpTest {

    public static void main(String[] args) {
        HttpRequest httpRequest = new HttpRequest();
        //请求地址
        String url = "https://douban.uieee.com/v2/movie/subject/26636712";
        String param = "";
        System.out.println(httpRequest.sendGet(url,param));


    }
}
