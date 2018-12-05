package com.sunfy.yy.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 影视时长
 */
public class Movie_Durations {

    @Id
    @GeneratedValue
    private Integer tid;

    //影视id
    private String subject_id;

    //影视时长
    private String durations_val;

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

    public String getDurations_val() {
        return durations_val;
    }

    public void setDurations_val(String durations_val) {
        this.durations_val = durations_val;
    }
}
