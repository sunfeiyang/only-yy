package com.sunfy.yy.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 豆瓣用户
 */
public class Movie_Author {

    @Id
    @GeneratedValue
    private Integer tid;

    //影视id
    private String subject_id;

    //豆瓣用户id
    private String author_id;

    //用户昵称
    private String author_uid;

    //用户名称
    private String author_name;

    //用户头像
    private String author_avatar;

    //用户简介
    private String author_signature;

    //豆瓣链接
    private String author_alt;

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

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_uid() {
        return author_uid;
    }

    public void setAuthor_uid(String author_uid) {
        this.author_uid = author_uid;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_avatar() {
        return author_avatar;
    }

    public void setAuthor_avatar(String author_avatar) {
        this.author_avatar = author_avatar;
    }

    public String getAuthor_signature() {
        return author_signature;
    }

    public void setAuthor_signature(String author_signature) {
        this.author_signature = author_signature;
    }

    public String getAuthor_alt() {
        return author_alt;
    }

    public void setAuthor_alt(String author_alt) {
        this.author_alt = author_alt;
    }
}
