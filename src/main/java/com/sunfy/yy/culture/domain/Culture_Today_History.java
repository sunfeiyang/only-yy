package com.sunfy.yy.culture.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 历史上的今天
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(uniqueConstraints = {@UniqueConstraint(columnNames="today_history_title")})
public class Culture_Today_History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    //总条数
    @Column(columnDefinition = "varchar(36) comment '总条数'")
    private String today_history_total;

    //月
    @Column(columnDefinition = "varchar(36) comment '月'")
    private Integer today_history_month;

    //日
    @Column(columnDefinition = "varchar(36) comment '日'")
    private Integer today_history_day;

    //内容
    @Column(name = "today_history_title",columnDefinition = "varchar(4000) comment '内容'")
    private String todayhistorytitle;

    //类型1、国际2、民间
    @Column(columnDefinition = "varchar(36) comment '类型1、国际2、民间'")
    private Integer today_history_type;

    //年
    @Column(columnDefinition = "varchar(36) comment '年'")
    private Integer today_history_year;

    //创建时间
    @CreatedDate
    @Column(columnDefinition = "varchar(128) comment '创建时间'")
    private String createtime;

    //更新时间
    @LastModifiedDate
    @Column(columnDefinition = "varchar(128) comment '更新时间'")
    private String updatetime;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getToday_history_total() {
        return today_history_total;
    }

    public void setToday_history_total(String today_history_total) {
        this.today_history_total = today_history_total;
    }

    public Integer getToday_history_month() {
        return today_history_month;
    }

    public void setToday_history_month(Integer today_history_month) {
        this.today_history_month = today_history_month;
    }

    public Integer getToday_history_day() {
        return today_history_day;
    }

    public void setToday_history_day(Integer today_history_day) {
        this.today_history_day = today_history_day;
    }

    public String getTodayhistorytitle() {
        return todayhistorytitle;
    }

    public void setTodayhistorytitle(String todayhistorytitle) {
        this.todayhistorytitle = todayhistorytitle;
    }

    public Integer getToday_history_type() {
        return today_history_type;
    }

    public void setToday_history_type(Integer today_history_type) {
        this.today_history_type = today_history_type;
    }

    public Integer getToday_history_year() {
        return today_history_year;
    }

    public void setToday_history_year(Integer today_history_year) {
        this.today_history_year = today_history_year;
    }

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
}
