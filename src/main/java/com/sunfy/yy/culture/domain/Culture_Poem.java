package com.sunfy.yy.culture.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 唐诗宋词
 */
@Entity
public class Culture_Poem {

    @Id
    @GeneratedValue
    private Integer tid;

    //id
    private String poem_id;

    //标题
    @Column(name = "poem_biaoti")
    private String poembiaoti;

    //介绍
    private String poem_jieshao;

    //作者
    @Column(name = "poem_zuozhe")
    private String poemzuozhe;

    //内容
    @Column(name = "poem_neirong")
    private String poemneirong;

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
}
