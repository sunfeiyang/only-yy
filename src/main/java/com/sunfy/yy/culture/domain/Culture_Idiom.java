package com.sunfy.yy.culture.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 成语
 */
public class Culture_Idiom {

    @Id
    @GeneratedValue
    private Integer tid;

    //内容
    private String idiom_name;

    //id
    private String idiom_id;

    //例子
    private String idiom_samples;

    //来历
    private String idiom_derivation;

    //解释
    private String idiom_content;

    //拼音
    private String idiom_spell;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getIdiom_name() {
        return idiom_name;
    }

    public void setIdiom_name(String idiom_name) {
        this.idiom_name = idiom_name;
    }

    public String getIdiom_id() {
        return idiom_id;
    }

    public void setIdiom_id(String idiom_id) {
        this.idiom_id = idiom_id;
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
}
