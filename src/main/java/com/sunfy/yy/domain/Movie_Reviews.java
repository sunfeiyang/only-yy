package com.sunfy.yy.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 影视长评
 */
public class Movie_Reviews {

    @Id
    @GeneratedValue
    private Integer tid;

    //影视id
    private String subject_id;

    //评论id
    private String reviews_id;

    //最高评分
    private String reviews_rating_max;

    //最低评分
    private String reviews_rating_min;

    //当前评分
    private String reviews_rating_value;

    //有用数
    private String reviews_useful_count;

    //无用数
    private String reviews_useless_count;

    //评论人id
    private String reviews_author_id;

    //创建日期
    private String reviews_created_at;

    //更新日期
    private String reviews_updated_at;

    //评论标题
    private String reviews_title;

    //评论简介
    private String reviews_summary;

    //评论详情
    private String reviews_content;

    //豆瓣链接
    private String reviews_alt;

    //
    private String reviews_comments_count;

    //评论链接
    private String reviews_share_url;

    //评论总条数
    private String reviews_total;

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

    public String getReviews_id() {
        return reviews_id;
    }

    public void setReviews_id(String reviews_id) {
        this.reviews_id = reviews_id;
    }

    public String getReviews_rating_max() {
        return reviews_rating_max;
    }

    public void setReviews_rating_max(String reviews_rating_max) {
        this.reviews_rating_max = reviews_rating_max;
    }

    public String getReviews_rating_min() {
        return reviews_rating_min;
    }

    public void setReviews_rating_min(String reviews_rating_min) {
        this.reviews_rating_min = reviews_rating_min;
    }

    public String getReviews_rating_value() {
        return reviews_rating_value;
    }

    public void setReviews_rating_value(String reviews_rating_value) {
        this.reviews_rating_value = reviews_rating_value;
    }

    public String getReviews_useful_count() {
        return reviews_useful_count;
    }

    public void setReviews_useful_count(String reviews_useful_count) {
        this.reviews_useful_count = reviews_useful_count;
    }

    public String getReviews_useless_count() {
        return reviews_useless_count;
    }

    public void setReviews_useless_count(String reviews_useless_count) {
        this.reviews_useless_count = reviews_useless_count;
    }

    public String getReviews_author_id() {
        return reviews_author_id;
    }

    public void setReviews_author_id(String reviews_author_id) {
        this.reviews_author_id = reviews_author_id;
    }

    public String getReviews_created_at() {
        return reviews_created_at;
    }

    public void setReviews_created_at(String reviews_created_at) {
        this.reviews_created_at = reviews_created_at;
    }

    public String getReviews_updated_at() {
        return reviews_updated_at;
    }

    public void setReviews_updated_at(String reviews_updated_at) {
        this.reviews_updated_at = reviews_updated_at;
    }

    public String getReviews_title() {
        return reviews_title;
    }

    public void setReviews_title(String reviews_title) {
        this.reviews_title = reviews_title;
    }

    public String getReviews_summary() {
        return reviews_summary;
    }

    public void setReviews_summary(String reviews_summary) {
        this.reviews_summary = reviews_summary;
    }

    public String getReviews_content() {
        return reviews_content;
    }

    public void setReviews_content(String reviews_content) {
        this.reviews_content = reviews_content;
    }

    public String getReviews_alt() {
        return reviews_alt;
    }

    public void setReviews_alt(String reviews_alt) {
        this.reviews_alt = reviews_alt;
    }

    public String getReviews_comments_count() {
        return reviews_comments_count;
    }

    public void setReviews_comments_count(String reviews_comments_count) {
        this.reviews_comments_count = reviews_comments_count;
    }

    public String getReviews_share_url() {
        return reviews_share_url;
    }

    public void setReviews_share_url(String reviews_share_url) {
        this.reviews_share_url = reviews_share_url;
    }

    public String getReviews_total() {
        return reviews_total;
    }

    public void setReviews_total(String reviews_total) {
        this.reviews_total = reviews_total;
    }
}
