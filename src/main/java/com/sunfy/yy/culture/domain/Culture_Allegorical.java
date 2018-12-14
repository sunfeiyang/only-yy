package com.sunfy.yy.culture.domain;

import javax.persistence.*;

/**
 * 歇后语
 */
@Entity
public class Culture_Allegorical {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*
    环境：@GeneratedValue(strategy = GenerationType.AUTO)，数据库用的mysql
    问题：
    1.发现数据库保存的时候会生成hibernate_sequence表，用来记录其他表的主键。若删除该表，
    将报错could not read a hi value - you need to populate the table: hibernate_sequence。
    2.服务器重启时主键从1开始记录，由于数据库里有主键为1的数据，于是会报主键重复的错误。
    解决方法：
    将@GeneratedValue(strategy = GenerationType.AUTO)改为@GeneratedValue(strategy = GenerationType.IDENTITY) 。
    原因：
    @GeneratedValue(strategy = GenerationType.AUTO)主键增长方式由数据库自动选择，当数据库选择sequence方式时，出现如上错误。
    @GeneratedValue(strategy = GenerationType.IDENTITY) 要求数据库选择自增方式，oracle不支持此种方式。
    @GeneratedValue(strategy = GenerationType.SEQUENCE)采用数据库提供的sequence机制生成主键。mysql不支持此种方式。
    @GeneratedValue(strategy = GenerationType.TABLE)没太看懂怎么存储的。
     */
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
