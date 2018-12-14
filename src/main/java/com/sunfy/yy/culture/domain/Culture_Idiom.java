package com.sunfy.yy.culture.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 成语
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Culture_Idiom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    //内容
    @Column(name = "idiom_name")
    private String idiomname;

    //id
    @Column(name = "idiom_id")
    private String idiomid;

    //例子
    private String idiom_samples;

    //来历
    private String idiom_derivation;

    //解释
    private String idiom_content;

    //拼音
    private String idiom_spell;

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

    public String getIdiomname() {
        return idiomname;
    }

    public void setIdiomname(String idiomname) {
        this.idiomname = idiomname;
    }

    public String getIdiomid() {
        return idiomid;
    }

    public void setIdiomid(String idiomid) {
        this.idiomid = idiomid;
    }

    public String getIdiom_samples() {
        return idiom_samples;
    }

    public void setIdiom_samples(String idiom_samples) {
        this.idiom_samples = idiom_samples;
    }

    public String getIdiom_derivation() {
        return idiom_derivation;
    }

    public void setIdiom_derivation(String idiom_derivation) {
        this.idiom_derivation = idiom_derivation;
    }

    public String getIdiom_content() {
        return idiom_content;
    }

    public void setIdiom_content(String idiom_content) {
        this.idiom_content = idiom_content;
    }

    public String getIdiom_spell() {
        return idiom_spell;
    }

    public void setIdiom_spell(String idiom_spell) {
        this.idiom_spell = idiom_spell;
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
