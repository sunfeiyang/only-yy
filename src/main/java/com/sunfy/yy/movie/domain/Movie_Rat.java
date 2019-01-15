package com.sunfy.yy.movie.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 影视评分
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(uniqueConstraints = {@UniqueConstraint(columnNames="subject_id")})
public class Movie_Rat {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    //影视id
    @Id
    @Column(name = "SUBJECT_ID",columnDefinition = "varchar(128) comment '影视id'")
    private String subjectid;

    //最高评分
    private String rat_max;

    //平均评分
    private String rat_average;

    //最低评分
    private String rat_min;

    //评分总数
    private String rat_total;

    //一星
    private String rat_details1;

    //两星
    private String rat_details2;

    //三星
    private String rat_details3;

    //四星
    private String rat_details4;

    //五星
    private String rat_details5;

    //
    private String rat_stars;

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

    public String getRat_max() {
        return rat_max;
    }

    public void setRat_max(String rat_max) {
        this.rat_max = rat_max;
    }

    public String getRat_average() {
        return rat_average;
    }

    public void setRat_average(String rat_average) {
        this.rat_average = rat_average;
    }

    public String getRat_min() {
        return rat_min;
    }

    public void setRat_min(String rat_min) {
        this.rat_min = rat_min;
    }

    public String getRat_total() {
        return rat_total;
    }

    public void setRat_total(String rat_total) {
        this.rat_total = rat_total;
    }

    public String getRat_details1() {
        return rat_details1;
    }

    public void setRat_details1(String rat_details1) {
        this.rat_details1 = rat_details1;
    }

    public String getRat_details2() {
        return rat_details2;
    }

    public void setRat_details2(String rat_details2) {
        this.rat_details2 = rat_details2;
    }

    public String getRat_details3() {
        return rat_details3;
    }

    public void setRat_details3(String rat_details3) {
        this.rat_details3 = rat_details3;
    }

    public String getRat_details4() {
        return rat_details4;
    }

    public void setRat_details4(String rat_details4) {
        this.rat_details4 = rat_details4;
    }

    public String getRat_details5() {
        return rat_details5;
    }

    public void setRat_details5(String rat_details5) {
        this.rat_details5 = rat_details5;
    }

    public String getRat_stars() {
        return rat_stars;
    }

    public void setRat_stars(String rat_stars) {
        this.rat_stars = rat_stars;
    }
}
