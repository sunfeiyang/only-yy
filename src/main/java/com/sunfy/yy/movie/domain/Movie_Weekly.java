package com.sunfy.yy.movie.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 影视语言
 */
public class Movie_Weekly {

    @Id
    @GeneratedValue
    private Integer tid;

    //影视id
    private String subject_id;

    //名称
    private String subject_title;

    //原名称
    private String subject_original_title;

    //类别
    private String subject_genres;

    //最高评级
    private String subject_rating_max;

    //当前评级
    private String subject_rating_average;

    //
    private String subject_rating_stars;

    //最低评级
    private String subject_rating_min;

    //收集数
    private String subject_collect_count;

    //影视类型
    private String subject_subtype;

    //年份
    private String subject_year;

    //豆瓣链接
    private String subject_hotshowalt;

    //片长
    private String subject_durations;

    //大陆上映日期
    private String subject_mainland_pubdate;

    //是否有资源
    private String subject_has_video;

    //海报
    private String subject_images;

    //豆瓣链接
    private String subject_alt;

    //变化趋势
    private String subject_delta;

    //排行
    private String subject_rank;

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

    public String getSubject_title() {
        return subject_title;
    }

    public void setSubject_title(String subject_title) {
        this.subject_title = subject_title;
    }

    public String getSubject_original_title() {
        return subject_original_title;
    }

    public void setSubject_original_title(String subject_original_title) {
        this.subject_original_title = subject_original_title;
    }

    public String getSubject_genres() {
        return subject_genres;
    }

    public void setSubject_genres(String subject_genres) {
        this.subject_genres = subject_genres;
    }

    public String getSubject_rating_max() {
        return subject_rating_max;
    }

    public void setSubject_rating_max(String subject_rating_max) {
        this.subject_rating_max = subject_rating_max;
    }

    public String getSubject_rating_average() {
        return subject_rating_average;
    }

    public void setSubject_rating_average(String subject_rating_average) {
        this.subject_rating_average = subject_rating_average;
    }

    public String getSubject_rating_stars() {
        return subject_rating_stars;
    }

    public void setSubject_rating_stars(String subject_rating_stars) {
        this.subject_rating_stars = subject_rating_stars;
    }

    public String getSubject_rating_min() {
        return subject_rating_min;
    }

    public void setSubject_rating_min(String subject_rating_min) {
        this.subject_rating_min = subject_rating_min;
    }

    public String getSubject_collect_count() {
        return subject_collect_count;
    }

    public void setSubject_collect_count(String subject_collect_count) {
        this.subject_collect_count = subject_collect_count;
    }

    public String getSubject_subtype() {
        return subject_subtype;
    }

    public void setSubject_subtype(String subject_subtype) {
        this.subject_subtype = subject_subtype;
    }

    public String getSubject_year() {
        return subject_year;
    }

    public void setSubject_year(String subject_year) {
        this.subject_year = subject_year;
    }

    public String getSubject_hotshowalt() {
        return subject_hotshowalt;
    }

    public void setSubject_hotshowalt(String subject_hotshowalt) {
        this.subject_hotshowalt = subject_hotshowalt;
    }

    public String getSubject_durations() {
        return subject_durations;
    }

    public void setSubject_durations(String subject_durations) {
        this.subject_durations = subject_durations;
    }

    public String getSubject_mainland_pubdate() {
        return subject_mainland_pubdate;
    }

    public void setSubject_mainland_pubdate(String subject_mainland_pubdate) {
        this.subject_mainland_pubdate = subject_mainland_pubdate;
    }

    public String getSubject_has_video() {
        return subject_has_video;
    }

    public void setSubject_has_video(String subject_has_video) {
        this.subject_has_video = subject_has_video;
    }

    public String getSubject_images() {
        return subject_images;
    }

    public void setSubject_images(String subject_images) {
        this.subject_images = subject_images;
    }

    public String getSubject_alt() {
        return subject_alt;
    }

    public void setSubject_alt(String subject_alt) {
        this.subject_alt = subject_alt;
    }

    public String getSubject_delta() {
        return subject_delta;
    }

    public void setSubject_delta(String subject_delta) {
        this.subject_delta = subject_delta;
    }

    public String getSubject_rank() {
        return subject_rank;
    }

    public void setSubject_rank(String subject_rank) {
        this.subject_rank = subject_rank;
    }
}
