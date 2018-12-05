package com.sunfy.yy.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 影视国别
 */
public class Movie_Countries {

    @Id
    @GeneratedValue
    private Integer tid;

    //影视id
    private String subject_id;

    //影视国别
    private String countries_val;

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

    public String getCountries_val() {
        return countries_val;
    }

    public void setCountries_val(String countries_val) {
        this.countries_val = countries_val;
    }
}
