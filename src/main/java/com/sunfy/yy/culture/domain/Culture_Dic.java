package com.sunfy.yy.culture.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 新华字典
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(uniqueConstraints = {@UniqueConstraint(columnNames="dic_hanzi")})
public class Culture_Dic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    //汉字
    @Column(name = "dic_hanzi",columnDefinition = "varchar(64) comment '汉字'")
    private String dichanzi;

    //拼音
    @Column(columnDefinition = "varchar(128) comment '拼音'")
    private String dic_pinyin;

    //读音
    @Column(columnDefinition = "varchar(128) comment '读音'")
    private String dic_duyin;

    //部首
    @Column(columnDefinition = "varchar(64) comment '部首'")
    private String dic_bushou;

    //笔画
    @Column(columnDefinition = "varchar(64) comment '笔画'")
    private Integer dic_bihua;

    //简介
    @Column(columnDefinition = "varchar(512) comment '简介'")
    private String dic_jianjie;

    //详解
    @Column(columnDefinition = "text(0) comment '详解'")
    private String dic_xiangjie;

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

    public String getDichanzi() {
        return dichanzi;
    }

    public void setDichanzi(String dichanzi) {
        this.dichanzi = dichanzi;
    }

    public String getDic_pinyin() {
        return dic_pinyin;
    }

    public void setDic_pinyin(String dic_pinyin) {
        this.dic_pinyin = dic_pinyin;
    }

    public String getDic_duyin() {
        return dic_duyin;
    }

    public void setDic_duyin(String dic_duyin) {
        this.dic_duyin = dic_duyin;
    }

    public String getDic_bushou() {
        return dic_bushou;
    }

    public void setDic_bushou(String dic_bushou) {
        this.dic_bushou = dic_bushou;
    }

    public Integer getDic_bihua() {
        return dic_bihua;
    }

    public void setDic_bihua(Integer dic_bihua) {
        this.dic_bihua = dic_bihua;
    }

    public String getDic_jianjie() {
        return dic_jianjie;
    }

    public void setDic_jianjie(String dic_jianjie) {
        this.dic_jianjie = dic_jianjie;
    }

    public String getDic_xiangjie() {
        return dic_xiangjie;
    }

    public void setDic_xiangjie(String dic_xiangjie) {
        this.dic_xiangjie = dic_xiangjie;
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
