package com.sunfy.yy.culture.service;

import com.sunfy.yy.culture.domain.Culture_Poem;

import java.util.ArrayList;

/**
 * 唐诗宋词
 */
public interface Culture_Poem_Service {

    /**
     * 插入数据列表
     * @param url 数据请求链接
     * @return ArrayList
     */
    public ArrayList addPoemList(String url);

    /**
     * 随机插入生成一条数据
     * @param url 数据请求链接
     * @return ArrayList
     */
    public ArrayList addPoem(String url);

    /**
     * 随机插入生成一条数据
     * @param url 数据请求链接
     * @return ArrayList
     */
    public ArrayList<Culture_Poem> addPoemRandom(String url);
}
