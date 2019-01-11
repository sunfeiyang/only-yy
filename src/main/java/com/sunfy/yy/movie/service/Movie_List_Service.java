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
    public ArrayList setInTheaters(Integer count,Integer start,Boolean idDel);

    /**
     * 即将上映
     * @return ArrayList
     */
    public ArrayList setComingSoon(Integer count,Integer start,Boolean isDel);

    /**
     * 北美票房榜
     * @return ArrayList
     */ 
    public ArrayList setUsBox(Boolean isDel);

    /**
     * 一周口碑榜
     * @return ArrayList
     */
    public ArrayList setWeekly(Boolean isDel);

    /**
     * TOP250
     * @return ArrayList
     */
    public ArrayList setTop250(Integer count,Integer start,Boolean isDel);

    /**
     * 新片榜
     * @return ArrayList
     */
    public ArrayList setNewMovies(Boolean isDel);

    /**
     * 正在热映
     * @return ArrayList
     */
    public ArrayList getInTheaters(Integer count,Integer start);

    /**
     * 即将上映
     * @return ArrayList
     */
    public ArrayList getComingSoon(Integer count,Integer start);

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
    public ArrayList getTop250(Integer count,Integer start);

    /**
     * 新片榜
     * @return ArrayList
     */
    public ArrayList getNewMovies();
}
