package com.sunfy.yy.culture.service;

import com.sunfy.yy.culture.domain.Culture_Allegorical;

import java.util.ArrayList;

/**
 * 歇后语
 */
public interface Culture_Allegorical_Service {

    /**
     * 插入数据列表
     * @param url 数据请求链接
     * @return ArrayList
     */
    public ArrayList<Culture_Allegorical> addAllegorical(String url);

    /**
     * 随机插入生成一条数据
     * @param url 数据请求链接
     * @return ArrayList
     */
    public ArrayList<Culture_Allegorical> addAllegoricalRandom(String url);

}
