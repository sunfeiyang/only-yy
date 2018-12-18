package com.sunfy.yy.culture.service;

import java.util.ArrayList;

/**
 * 父类整体实现重复方法
 */
public interface Culture_Service {

    /**
     * 随机插入生成一条数据
     * @param url 数据请求链接
     * @return ArrayList
     */
    public ArrayList addRandom(String url, String repositoryType);

    /**
     * 插入数据列表
     * @param url 数据请求链接
     * @return ArrayList
     */
    public ArrayList addList(String url,String repositoryType);

    /**
     * 根据关键字查询列表然后获取对应详情插入数据
     * @param url 数据请求链接
     * @return ArrayList
     */
    public ArrayList addDetailsList(String url,String urlDetails,String repositoryType);
}
