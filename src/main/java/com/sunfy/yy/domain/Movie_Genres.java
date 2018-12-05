package com.sunfy.yy.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 影视类别
 */
public class Movie_Genres {

    @Id
    @GeneratedValue
    private Integer tid;

    //影视id
    private String subject_id;

    //影视类别
    private String genres_val;

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

    public String getGenres_val() {
        return genres_val;
    }

    public void setGenres_val(String genres_val) {
        this.genres_val = genres_val;
    }
}
