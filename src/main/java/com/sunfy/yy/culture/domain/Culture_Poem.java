package com.sunfy.yy.culture.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 唐诗宋词
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(uniqueConstraints = {@UniqueConstraint(columnNames="poem_id")})
public class Culture_Poem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    //id
    private String poem_id;

    //标题
    @Column(name = "poem_biaoti",columnDefinition = "varchar(512) comment '创建时间'")
    private String poembiaoti;

    //介绍
    @Column(columnDefinition = "varchar(2048) comment '介绍'")
    private String poem_jieshao;

    //作者
    @Column(name = "poem_zuozhe",columnDefinition = "varchar(128) comment '作者'")
    private String poemzuozhe;

    //内容
    @Column(name = "poem_neirong",columnDefinition = "text(0) comment '内容'")
    private String poemneirong;

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

    public String getPoem_id() {
        return poem_id;
    }

    public void setPoem_id(String poem_id) {
        this.poem_id = poem_id;
    }

    public String getPoembiaoti() {
        return poembiaoti;
    }

    public void setPoembiaoti(String poembiaoti) {
        this.poembiaoti = poembiaoti;
    }

    public String getPoem_jieshao() {
        return poem_jieshao;
    }

    public void setPoem_jieshao(String poem_jieshao) {
        this.poem_jieshao = poem_jieshao;
    }

    public String getPoemzuozhe() {
        return poemzuozhe;
    }

    public void setPoemzuozhe(String poemzuozhe) {
        this.poemzuozhe = poemzuozhe;
    }

    public String getPoemneirong() {
        return poemneirong;
    }

    public void setPoemneirong(String poemneirong) {
        this.poemneirong = poemneirong;
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
