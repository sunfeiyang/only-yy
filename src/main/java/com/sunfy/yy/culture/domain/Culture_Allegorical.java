package com.sunfy.yy.culture.domain;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 歇后语
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="CULTURE_ALLEGORICAL",
        uniqueConstraints = {@UniqueConstraint(columnNames={"allegorical_question", "allegorical_answer"})})
/*
@Table：该注解标注在类上，主要作用是定义该实体对应在数据库中的信息，有以下几个常用属性：
name：定义该实体对应数据库的表名，如果不指定，则使用类名作为表名；
catalog：用于指定数据库实例名。如果不指定，新建的表则出现在数据库连接url指定的数据库中；
schema：作用与catalog相同；
indexes：用于对表字段建立索引。如：indexes={@Index(name=”idx_name_address”, unique=false, columnList=”name,address”)}
uniqueConstraints：指定表的唯一性约束。可建立多个唯一性约束。如：uniqueConstraints={@UniqueConstraint(columnNames={“col1”,”col2”}),@UniqueConstraint(columnNames={“col3”,”col4”})}

原文：https://blog.csdn.net/LZJLZJLZJLZJLZJLZJ/article/details/78635157
 */
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
    @Column(name = "ALLEGORICAL_QUESTION",columnDefinition = "varchar(128) comment '前者'")
    private String allegoricalquestion;

    //后者
    @Column(name = "ALLEGORICAL_ANSWER",columnDefinition = "varchar(128) comment '后者'")
    private String allegoricalanswer;

    //字母
    @Column(columnDefinition = "varchar(16) comment '字母'")
    private String allegorical_zimu;

    //创建时间
    @CreatedDate
    /*
        在spring jpa中，支持在字段或者方法上进行注解@CreatedDate、@CreatedBy、@LastModifiedDate、@LastModifiedBy，从字面意思可以很清楚的了解，这几个注解的用处。
        @CreatedDate 表示该字段为创建时间时间字段，在这个实体被insert的时候，会设置值
        @CreatedBy 表示该字段为创建人，在这个实体被insert的时候，会设置值
        @LastModifiedDate、@LastModifiedBy同理。

        如何使用？
        首先申明实体类，需要在类上加上注解@EntityListeners(AuditingEntityListener.class)，其次在application启动类中加上注解EnableJpaAuditing，同时在需要的字段上加上@CreatedDate、@CreatedBy、@LastModifiedDate、@LastModifiedBy等注解。
        这个时候，在jpa.save方法被调用的时候，时间字段会自动设置并插入数据库，但是CreatedBy和LastModifiedBy并没有赋值，因为需要实现AuditorAware接口来返回你需要插入的值。
     */
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
