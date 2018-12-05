package com.sunfy.yy.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 影视标签
 */
public class Movie_Tags {

    @Id
    @GeneratedValue
    private Integer tid;

    //影视id
    private String subject_id;

    //标签内容
    private String tags_val;

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

    public String getTags_val() {
        return tags_val;
    }

    public void setTags_val(String tags_val) {
        this.tags_val = tags_val;
    }
}
