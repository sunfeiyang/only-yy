package com.sunfy.yy.movie.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 影视海报
 */
public class Movie_Images {

    @Id
    @GeneratedValue
    private Integer tid;

    //影视id
    private String subject_id;

    //海报尺寸（大）
    private String images_large;

    //海报尺寸（中）
    private String images_medium;

    //海报尺寸（小）
    private String images_small;

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

    public String getImages_large() {
        return images_large;
    }

    public void setImages_large(String images_large) {
        this.images_large = images_large;
    }

    public String getImages_medium() {
        return images_medium;
    }

    public void setImages_medium(String images_medium) {
        this.images_medium = images_medium;
    }

    public String getImages_small() {
        return images_small;
    }

    public void setImages_small(String images_small) {
        this.images_small = images_small;
    }
}
