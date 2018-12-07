package com.sunfy.yy.movie.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 影视语言
 */
public class Movie_Languages {

    @Id
    @GeneratedValue
    private Integer tid;

    //影视id
    private String subject_id;

    //影视语言
    private String languages_val;

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

    public String getLanguages_val() {
        return languages_val;
    }

    public void setLanguages_val(String languages_val) {
        this.languages_val = languages_val;
    }
}
