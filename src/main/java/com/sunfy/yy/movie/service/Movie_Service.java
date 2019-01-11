package com.sunfy.yy.movie.service;

import java.util.ArrayList;

/**
 * 写入movie数据公共接口
 */
public interface Movie_Service {

    /**
     * 写入数据
     * @param url 数据请求链接
     * @param repositoryType 数据请求类别
     * @param idDel 数据请求前是否清空原表数据
     * @return ArrayList
     */
    public ArrayList setMovie(String url,String repositoryType,Boolean idDel);

    /**
     * 读取数据
     * @param repositoryType 数据请求类别
     * @return ArrayList
     */
    public ArrayList getMovieList(String repositoryType);
}
