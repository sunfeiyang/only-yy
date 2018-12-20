package com.sunfy.yy.movie.service;

import java.util.ArrayList;

/**
 * 影片列表【包括正在热映、即将上映、各种类别排行等信息】
 */
public interface Movie_List_Service {

    /**
     * 正在热映
     * @param url 数据请求链接
     * @return ArrayList
     */
    public ArrayList getInTheaters(String url);

    /**
     * 即将上映
     * @param url 数据请求链接
     * @return ArrayList
     */
    public ArrayList getComingSoon(String url);

    /**
     * 北美票房榜
     * @param url 数据请求链接
     * @return ArrayList
     */
    public ArrayList getUsBox(String url);

    /**
     * 一周口碑榜
     * @param url 数据请求链接
     * @return ArrayList
     */
    public ArrayList getWeekly(String url);

    /**
     * TOP250
     * @param url 数据请求链接
     * @return ArrayList
     */
    public ArrayList getTop250(String url);

    /**
     * 新片榜
     * @param url 数据请求链接
     * @return ArrayList
     */
    public ArrayList getNewMovies(String url);
}
