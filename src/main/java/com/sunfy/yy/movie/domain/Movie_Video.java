package com.sunfy.yy.movie.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 影视资源
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Movie_Video {

    @Id
    @GeneratedValue
    private Integer tid;

    //影视id
    private String subject_id;

    //影视来源id
    private String video_id;

    //影视来源英文
    private String video_source_literal;

    //是否需要付费
    private String video_need_pay;

    //影视链接
    private String video_sample_link;

    //影视来源图标
    private String video_source_pic;

    //影视来源名称
    private String video_source_name;

    //创建时间
    @CreatedDate
    private String createtime;

    //更新时间
    @LastModifiedDate
    private String updatetime;

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

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

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public String getVideo_source_literal() {
        return video_source_literal;
    }

    public void setVideo_source_literal(String video_source_literal) {
        this.video_source_literal = video_source_literal;
    }

    public String getVideo_need_pay() {
        return video_need_pay;
    }

    public void setVideo_need_pay(String video_need_pay) {
        this.video_need_pay = video_need_pay;
    }

    public String getVideo_sample_link() {
        return video_sample_link;
    }

    public void setVideo_sample_link(String video_sample_link) {
        this.video_sample_link = video_sample_link;
    }

    public String getVideo_source_pic() {
        return video_source_pic;
    }

    public void setVideo_source_pic(String video_source_pic) {
        this.video_source_pic = video_source_pic;
    }

    public String getVideo_source_name() {
        return video_source_name;
    }

    public void setVideo_source_name(String video_source_name) {
        this.video_source_name = video_source_name;
    }
}
