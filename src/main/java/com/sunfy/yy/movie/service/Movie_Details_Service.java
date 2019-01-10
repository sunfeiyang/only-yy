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

}
