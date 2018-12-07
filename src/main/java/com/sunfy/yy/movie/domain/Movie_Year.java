package com.sunfy.yy.movie.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 影视年份
 */
public class Movie_Year {

    @Id
    @GeneratedValue
    private Integer tid;

    //影视id
    private String subject_id;

    //影视年份
    private String year_val;

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

    public String getYear_val() {
        return year_val;
    }

    public void setYear_val(String year_val) {
        this.year_val = year_val;
    }
}
