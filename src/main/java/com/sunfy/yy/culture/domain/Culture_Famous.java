package com.sunfy.yy.culture.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 名人名言实体类
 * Entity注解会检查数据库中是否存在该数据表，没有则会创建
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
/*
增加table注解后，Jpa会自动根据字段内容新增没有的字段，如果不写注解会做相应映射而不会新增字段
 */
//@Table(name = "culture_famous")
public class Culture_Famous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    //姓名
    @Column(name="famous_name")
    private String famousname;

    //内容
    @Column(name="famous_saying")
    private String famoussaying;

    //创建时间
    @CreatedDate
    private String createtime;

    //更新时间
    @LastModifiedDate
    private String updatetime;

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
