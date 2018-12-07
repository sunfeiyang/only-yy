package com.sunfy.yy.culture.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 歇后语
 */
public class Culture_Allegorical {

    @Id
    @GeneratedValue
    private Integer tid;

    //前者
    private String allegorical_question;

    //后者
    private String allegorical_answer;

    //字母
    private String allegorical_zimu;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getAllegorical_question() {
        return allegorical_question;
    }

    public void setAllegorical_question(String allegorical_question) {
        this.allegorical_question = allegorical_question;
    }

    public String getAllegorical_answer() {
        return allegorical_answer;
    }

    public void setAllegorical_answer(String allegorical_answer) {
        this.allegorical_answer = allegorical_answer;
    }

    public String getAllegorical_zimu() {
        return allegorical_zimu;
    }

    public void setAllegorical_zimu(String allegorical_zimu) {
        this.allegorical_zimu = allegorical_zimu;
    }
}
