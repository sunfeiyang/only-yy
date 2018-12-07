package com.sunfy.yy.culture.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 唐诗宋词
 */
public class Culture_Poem {

    @Id
    @GeneratedValue
    private Integer tid;

    //id
    private String poem_id;

    //标题
    private String poem_biaoti;

    //介绍
    private String poem_jieshao;

    //作者
    private String poem_zuozhe;

    //内容
    private String poem_neirong;

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

    public String getPoem_biaoti() {
        return poem_biaoti;
    }

    public void setPoem_biaoti(String poem_biaoti) {
        this.poem_biaoti = poem_biaoti;
    }

    public String getPoem_jieshao() {
        return poem_jieshao;
    }

    public void setPoem_jieshao(String poem_jieshao) {
        this.poem_jieshao = poem_jieshao;
    }

    public String getPoem_zuozhe() {
        return poem_zuozhe;
    }

    public void setPoem_zuozhe(String poem_zuozhe) {
        this.poem_zuozhe = poem_zuozhe;
    }

    public String getPoem_neirong() {
        return poem_neirong;
    }

    public void setPoem_neirong(String poem_neirong) {
        this.poem_neirong = poem_neirong;
    }
}
