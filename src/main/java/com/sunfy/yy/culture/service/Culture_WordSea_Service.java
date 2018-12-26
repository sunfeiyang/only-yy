package com.sunfy.yy.culture.service;

import com.sunfy.yy.culture.domain.Culture_WordSea;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 辞海
 */
public interface Culture_WordSea_Service {

    /**
     * 插入数据列表
     * @param url 数据请求链接
     * @return ArrayList
     */
    public ArrayList addList(String url);

    /**
     * 随机插入生成一条数据
     * @param url 数据请求链接
     * @return ArrayList
     */
    public ArrayList addRandom(String url);

    /**
     * 数据库根据条件查询数据
     * @param map 查询条件
     * @return ArrayList
     */
    public ArrayList selLikeList(Map map);

    /**
     * 分页查询
     * @param map 分页条件
     * @return ArrayList
     */
    public List selListPage(Map map);

}
