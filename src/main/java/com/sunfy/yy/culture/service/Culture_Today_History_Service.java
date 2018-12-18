package com.sunfy.yy.culture.service;

import java.util.ArrayList;

/**
 * 历史上的今天接口
 */
public interface Culture_Today_History_Service {

    /**
     * 插入数据列表
     * @param url 数据请求链接
     * @return ArrayList
     */
    public ArrayList addToday_History(String url);
}
