package com.sunfy.yy.movie.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 影视短评
 */
public class Movie_Comments {

    @Id
    @GeneratedValue
    private Integer tid;

    //影视id
    private String subject_id;

    //最高评分
    private String comments_rating_max;

    //最低评分
    private String comments_rating_min;

    //当前评分
    private String comments_rating_value;

    //
    private String comments_useful_count;

    //用户id
    private String comments_author_id;

    //短评内容
    private String comments_content;

    //发布时间
    private String comments_created_at;

    //豆瓣id
    private String comments_id;

    //短评总条数
    private String comments_total;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getComments_rating_max() {
        return comments_rating_max;
    }

    public void setComments_rating_max(String comments_rating_max) {
        this.comments_rating_max = comments_rating_max;
    }

    public String getComments_rating_min() {
        return comments_rating_min;
    }

    public void setComments_rating_min(String comments_rating_min) {
        this.comments_rating_min = comments_rating_min;
    }

    public String getComments_rating_value() {
        return comments_rating_value;
    }

    public void setComments_rating_value(String comments_rating_value) {
        this.comments_rating_value = comments_rating_value;
    }

    public String getComments_useful_count() {
        return comments_useful_count;
    }

    public void setComments_useful_count(String comments_useful_count) {
        this.comments_useful_count = comments_useful_count;
    }

    public String getComments_author_id() {
        return comments_author_id;
    }

    public void setComments_author_id(String comments_author_id) {
        this.comments_author_id = comments_author_id;
    }

    public String getComments_content() {
        return comments_content;
    }

    public void setComments_content(String comments_content) {
        this.comments_content = comments_content;
    }

    public String getComments_created_at() {
        return comments_created_at;
    }

    public void setComments_created_at(String comments_created_at) {
        this.comments_created_at = comments_created_at;
    }

    public String getComments_id() {
        return comments_id;
    }

    public void setComments_id(String comments_id) {
        this.comments_id = comments_id;
    }

    public String getComments_total() {
        return comments_total;
    }

    public void setComments_total(String comments_total) {
        this.comments_total = comments_total;
    }
}
