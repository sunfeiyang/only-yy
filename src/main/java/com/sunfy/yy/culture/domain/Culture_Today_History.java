package com.sunfy.yy.culture.domain;

import javax.persistence.*;

/**
 * 历史上的今天
 */
@Entity
public class Culture_Today_History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    //总条数
    private String today_history_total;

    //月
    private Integer today_history_month;

    //日
    private Integer today_history_day;

    //内容
    @Column(name = "today_history_title")
    private String todayhistorytitle;

    //类型1、国际2、民间
    private Integer today_history_type;

    //年
    private Integer today_history_year;

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
}
