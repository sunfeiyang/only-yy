package com.sunfy.yy.movie.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 上映日期
 */
public class Movie_Pubdate {

    @Id
    @GeneratedValue
    private Integer tid;

    //影视id
    private String subject_id;

    //上映日期
    private String pubdate_date;

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

    public String getPubdate_date() {
        return pubdate_date;
    }

    public void setPubdate_date(String pubdate_date) {
        this.pubdate_date = pubdate_date;
    }
}
