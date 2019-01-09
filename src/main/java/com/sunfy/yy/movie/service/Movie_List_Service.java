package com.sunfy.yy.movie.service;

import java.util.ArrayList;

/**
 * 影片列表【包括正在热映、即将上映、各种类别排行等信息】
 */
public interface Movie_List_Service {

    /**
     * 正在热映
     * @return ArrayList
     */
    public ArrayList getInTheaters();

    /**
     * 即将上映
     * @return ArrayList
     */
    public ArrayList getComingSoon();

    /**
     * 北美票房榜
     * @return ArrayList
     */
    public ArrayList getUsBox();

    /**
     * 一周口碑榜
     * @return ArrayList
     */
    public ArrayList getWeekly();

    /**
     * TOP250
     * @return ArrayList
     */
    public ArrayList getTop250();

    /**
     * 新片榜
     * @return ArrayList
     */
    public ArrayList getNewMovies();
}
