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
    @Column(name = "today_history_month",columnDefinition = "varchar(36) comment '月'")
    private Integer todayhistorymonth;

    //日
    @Column(name = "today_history_day",columnDefinition = "varchar(36) comment '日'")
    private Integer todayhistoryday;

    //内容
    @Column(name = "today_history_title",columnDefinition = "varchar(4000) comment '内容'")
    private String todayhistorytitle;

    //类型1、国际2、民间
    @Column(name = "today_history_type",columnDefinition = "varchar(36) comment '类型1、国际2、民间'")
    private Integer todayhistorytype;

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

    public Integer getTodayhistorymonth() {
        return todayhistorymonth;
    }

    public void setTodayhistorymonth(Integer todayhistorymonth) {
        this.todayhistorymonth = todayhistorymonth;
    }

    public Integer getTodayhistoryday() {
        return todayhistoryday;
    }

    public void setTodayhistoryday(Integer todayhistoryday) {
        this.todayhistoryday = todayhistoryday;
    }

    public String getTodayhistorytitle() {
        return todayhistorytitle;
    }

    public void setTodayhistorytitle(String todayhistorytitle) {
        this.todayhistorytitle = todayhistorytitle;
    }

    public Integer getTodayhistorytype() {
        return todayhistorytype;
    }

    public void setTodayhistorytype(Integer todayhistorytype) {
        this.todayhistorytype = todayhistorytype;
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
