package com.sunfy.yy.movie.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 上映日期
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(uniqueConstraints = {@UniqueConstraint(columnNames="subject_id")})
public class Movie_Pubdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    //影视id
    @Column(name = "SUBJECT_ID",columnDefinition = "varchar(128) comment '影视id'")
    private String subjectid;

    //上映日期
    private String pubdate_date;

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

    public String getPubdate_date() {
        return pubdate_date;
    }

    public void setPubdate_date(String pubdate_date) {
        this.pubdate_date = pubdate_date;
    }
}
