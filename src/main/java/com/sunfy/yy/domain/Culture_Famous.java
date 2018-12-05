package com.sunfy.yy.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 名人名言实体类
 */
@Entity
public class Culture_Famous {

    @Id
    @GeneratedValue
    private Integer tid;

    //姓名
    private String famous_name;

    //内容
    private String famous_saying;

    public Culture_Famous() {
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getFamous_name() {
        return famous_name;
    }

    public void setFamous_name(String famous_name) {
        this.famous_name = famous_name;
    }

    public String getFamous_saying() {
        return famous_saying;
    }

    public void setFamous_saying(String famous_saying) {
        this.famous_saying = famous_saying;
    }

    @Override
    public String toString() {
        return "Culture_Famous{" +
                "tid=" + tid +
                ", famous_name='" + famous_name + '\'' +
                ", famous_saying=" + famous_saying +
                '}';
    }
}
