package com.sunfy.yy.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 影视标签
 */
public class Movie_Casts {

    @Id
    @GeneratedValue
    private Integer tid;

    //影视id
    private String subject_id;

    //演员ID
    private String casts_id;

    //演员姓名
    private String casts_name;

    //演员姓名（英）
    private String casts_name_en;

    //豆瓣链接
    private String casts_alt;

    //图片连接（大）
    private String casts_avatars_large;

    //图片连接（中）
    private String casts_avatars_medium;

    //图片连接（小）
    private String casts_avatars_small;

    //导演1、编剧2、演员3
    private String casts_type;

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

    public String getCasts_id() {
        return casts_id;
    }

    public void setCasts_id(String casts_id) {
        this.casts_id = casts_id;
    }

    public String getCasts_name() {
        return casts_name;
    }

    public void setCasts_name(String casts_name) {
        this.casts_name = casts_name;
    }

    public String getCasts_name_en() {
        return casts_name_en;
    }

    public void setCasts_name_en(String casts_name_en) {
        this.casts_name_en = casts_name_en;
    }

    public String getCasts_alt() {
        return casts_alt;
    }

    public void setCasts_alt(String casts_alt) {
        this.casts_alt = casts_alt;
    }

    public String getCasts_avatars_large() {
        return casts_avatars_large;
    }

    public void setCasts_avatars_large(String casts_avatars_large) {
        this.casts_avatars_large = casts_avatars_large;
    }

    public String getCasts_avatars_medium() {
        return casts_avatars_medium;
    }

    public void setCasts_avatars_medium(String casts_avatars_medium) {
        this.casts_avatars_medium = casts_avatars_medium;
    }

    public String getCasts_avatars_small() {
        return casts_avatars_small;
    }

    public void setCasts_avatars_small(String casts_avatars_small) {
        this.casts_avatars_small = casts_avatars_small;
    }

    public String getCasts_type() {
        return casts_type;
    }

    public void setCasts_type(String casts_type) {
        this.casts_type = casts_type;
    }
}
