package com.sunfy.yy.culture.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 歇后语
 */
@Entity
public class Culture_Allegorical {

    @Id
    @GeneratedValue
    private Integer tid;

    //前者
    @Column(name = "allegorical_question")
    private String allegoricalquestion;

    //后者
    @Column(name = "allegorical_answer")
    private String allegoricalanswer;

    //字母
    private String allegorical_zimu;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getAllegoricalquestion() {
        return allegoricalquestion;
    }

    public void setAllegoricalquestion(String allegoricalquestion) {
        this.allegoricalquestion = allegoricalquestion;
    }

    public String getAllegoricalanswer() {
        return allegoricalanswer;
    }

    public void setAllegoricalanswer(String allegoricalanswer) {
        this.allegoricalanswer = allegoricalanswer;
    }

    public String getAllegorical_zimu() {
        return allegorical_zimu;
    }

    public void setAllegorical_zimu(String allegorical_zimu) {
        this.allegorical_zimu = allegorical_zimu;
    }
}
