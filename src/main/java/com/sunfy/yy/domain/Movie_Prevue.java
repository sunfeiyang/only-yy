package com.sunfy.yy.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 影视预告
 */
public class Movie_Prevue {

    @Id
    @GeneratedValue
    private Integer tid;

    //影视id
    private String subject_id;

    //预告片id
    private String prevue_id;

    //预告片图片（中）
    private String prevue_medium;

    //预告片图片（小）
    private String prevue_small;

    //预告片链接
    private String prevue_resource_url;

    //豆瓣链接
    private String prevue_alt;

    //预告片标题
    private String prevue_title;

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

    public String getPrevue_id() {
        return prevue_id;
    }

    public void setPrevue_id(String prevue_id) {
        this.prevue_id = prevue_id;
    }

    public String getPrevue_medium() {
        return prevue_medium;
    }

    public void setPrevue_medium(String prevue_medium) {
        this.prevue_medium = prevue_medium;
    }

    public String getPrevue_small() {
        return prevue_small;
    }

    public void setPrevue_small(String prevue_small) {
        this.prevue_small = prevue_small;
    }

    public String getPrevue_resource_url() {
        return prevue_resource_url;
    }

    public void setPrevue_resource_url(String prevue_resource_url) {
        this.prevue_resource_url = prevue_resource_url;
    }

    public String getPrevue_alt() {
        return prevue_alt;
    }

    public void setPrevue_alt(String prevue_alt) {
        this.prevue_alt = prevue_alt;
    }

    public String getPrevue_title() {
        return prevue_title;
    }

    public void setPrevue_title(String prevue_title) {
        this.prevue_title = prevue_title;
    }
}
