package com.sunfy.yy.culture.service;

import com.sunfy.yy.culture.domain.Culture_Idiom;

import java.util.ArrayList;

/**
 * 成语
 */
public interface Culture_Idiom_Service {

    /**
     * 根据关键字查询列表然后获取对应详情插入数据
     * @param url 数据请求链接
     * @return ArrayList
     */
    public ArrayList addIdiomList(String url);

    /**
     * 插入数据列表
     * @param url 数据请求链接
     * @return ArrayList
     */
    public ArrayList addIdiom(String url);

    /**
     * 随机插入生成一条数据
     * @param url 数据请求链接
     * @return ArrayList
     */
    public ArrayList<Culture_Idiom> addIdiomRandom(String url);
}
