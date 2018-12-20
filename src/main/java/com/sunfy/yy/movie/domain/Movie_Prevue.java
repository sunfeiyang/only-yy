package com.sunfy.yy.movie.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 影视预告
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(uniqueConstraints = {@UniqueConstraint(columnNames={"subject_id","prevue_id"})})
public class Movie_Prevue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    //影视id
    @Column(name = "SUBJECT_ID",columnDefinition = "varchar(128) comment '影视id'")
    private String subjectid;

    //预告片id
    @Column(name = "PREVUE_ID",columnDefinition = "varchar(128) comment '预告片id'")
    private String prevuid;

    //预告片图片（中）
    private String prevue_medium;

    //预告片图片（小）
    private String prevue_small;

    //预告片链接
    private String prevue_resource_url;

    //豆瓣链接
    private String prevue_alt;

    //预告片标题
    private String prevue_title;

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

    public String getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(String subjectid) {
        this.subjectid = subjectid;
    }

    public String getPrevuid() {
        return prevuid;
    }

    public void setPrevuid(String prevuid) {
        this.prevuid = prevuid;
    }

    public String getPrevue_medium() {
        return prevue_medium;
    }

    public void setPrevue_medium(String prevue_medium) {
        this.prevue_medium = prevue_medium;
    }

    public String getPrevue_small() {
        return prevue_small;
    }

    public void setPrevue_small(String prevue_small) {
        this.prevue_small = prevue_small;
    }

    public String getPrevue_resource_url() {
        return prevue_resource_url;
    }

    public void setPrevue_resource_url(String prevue_resource_url) {
        this.prevue_resource_url = prevue_resource_url;
    }

    public String getPrevue_alt() {
        return prevue_alt;
    }

    public void setPrevue_alt(String prevue_alt) {
        this.prevue_alt = prevue_alt;
    }

    public String getPrevue_title() {
        return prevue_title;
    }

    public void setPrevue_title(String prevue_title) {
        this.prevue_title = prevue_title;
    }
}
