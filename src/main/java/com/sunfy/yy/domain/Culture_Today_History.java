package com.sunfy.yy.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 历史上的今天
 */
public class Culture_Today_History {

    @Id
    @GeneratedValue
    private Integer tid;

    //总条数
    private String today_history_total;

    //月
    private String today_history_month;

    //日
    private String today_history_day;

    //内容
    private String today_history_title;

    //类型1、国际2、民间
    private String today_history_type;

    //年
    private String today_history_year;

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

    public String getToday_history_month() {
        return today_history_month;
    }

    public void setToday_history_month(String today_history_month) {
        this.today_history_month = today_history_month;
    }

    public String getToday_history_day() {
        return today_history_day;
    }

    public void setToday_history_day(String today_history_day) {
        this.today_history_day = today_history_day;
    }

    public String getToday_history_title() {
        return today_history_title;
    }

    public void setToday_history_title(String today_history_title) {
        this.today_history_title = today_history_title;
    }

    public String getToday_history_type() {
        return today_history_type;
    }

    public void setToday_history_type(String today_history_type) {
        this.today_history_type = today_history_type;
    }

    public String getToday_history_year() {
        return today_history_year;
    }

    public void setToday_history_year(String today_history_year) {
        this.today_history_year = today_history_year;
    }
}
