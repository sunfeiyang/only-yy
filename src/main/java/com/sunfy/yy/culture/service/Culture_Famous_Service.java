package com.sunfy.yy.culture.service;

import java.util.ArrayList;

/**
 * 名人名言
 */
public interface Culture_Famous_Service {

    /**
     * 插入数据列表
     * @param url 数据请求链接
     * @return ArrayList
     */
    public ArrayList addFamous(String url);

    /**
     * 随机插入生成一条数据
     * @param url 数据请求链接
     * @return ArrayList
     */
    public ArrayList addFamousRandom(String url);
}
