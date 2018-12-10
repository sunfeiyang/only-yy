package com.sunfy.yy.culture.domain;

import javax.persistence.*;

/**
 * 名人名言实体类
 * Entity注解会检查数据库中是否存在该数据表，没有则会创建
 */
@Entity
/*
增加table注解后，Jpa会自动根据字段内容新增没有的字段，如果不写注解会做相应映射而不会新增字段
 */
//@Table(name = "culture_famous")
public class Culture_Famous {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer tid;

    //姓名
    @Column(name="famous_name")
    private String famousname;

    //内容
    @Column(name="famous_saying")
    private String famoussaying;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getFamousname() {
        return famousname;
    }

    public void setFamousname(String famousname) {
        this.famousname = famousname;
    }

    public String getFamoussaying() {
        return famoussaying;
    }

    public void setFamoussaying(String famoussaying) {
        this.famoussaying = famoussaying;
    }
}
