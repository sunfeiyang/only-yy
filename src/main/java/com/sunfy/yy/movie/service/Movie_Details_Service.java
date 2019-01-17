package com.sunfy.yy.movie.service;

import java.util.ArrayList;

/**
 * 电影详情
 */
public interface Movie_Details_Service {

    /**
     * 根据电影ID插入数据
     * @param subjectID 影片ID
     * @return ArrayList
     */
    public ArrayList setSubjectDetails(String subjectID);

    /**
     * 根据电影ID插入标签
     * @param subjectID 影片ID
     * @return ArrayList
     */
    public void setTags_url(String subjectID);

    /**
     * 根据电影ID插入短评
     * @param subjectID 影片ID
     * @return ArrayList
     */
    public void setComments_url(String subjectID);

    /**
     * 根据电影ID插入长评
     * @param subjectID 影片ID
     * @return ArrayList
     */
    public void setReviews_url(String subjectID);

    /**
     * 根据电影ID插入剧照
     * @param subjectID 影片ID
     * @return ArrayList
     */
    public void setPhotos_url(String subjectID);


    /**
     * 根据电影ID查询数据
     * @param subjectID 影片ID
     * @return ArrayList
     */
    public ArrayList getSubjectDetails(String subjectID);

    /**
     * 根据电影ID查询标签
     * @param subjectID 影片ID
     * @return ArrayList
     */
    public ArrayList getTags_url(String subjectID);

    /**
     * 根据电影ID查询短评
     * @param subjectID 影片ID
     * @return ArrayList
     */
    public ArrayList getComments(String subjectID);

    /**
     * 根据电影ID查询长评
     * @param subjectID 影片ID
     * @return ArrayList
     */
    public ArrayList getReviews(String subjectID);

    /**
     * 根据电影ID查询剧照
     * @param subjectID 影片ID
     * @return ArrayList
     */
    public ArrayList getPhotos(String subjectID);

    /**
     * 根据电影ID查询演职员
     * @param subjectID 影片ID
     * @return ArrayList
     */
    public ArrayList getCasts(String subjectID);

    /**
     * 根据电影ID查询评分
     * @param subjectID 影片ID
     * @return ArrayList
     */
    public ArrayList getRat(String subjectID);

}
