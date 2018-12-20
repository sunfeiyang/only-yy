package com.sunfy.yy.movie.service;

import java.util.ArrayList;

/**
 * 写入movie数据公共接口
 */
public interface Movie_Service {

    /**
     * 写入数据
     * @param url 数据请求链接
     * @return ArrayList
     */
    public ArrayList setMovie(String url,String repositoryType);
}
