package com.sunfy.yy.common.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 轮播图
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Common_Carousel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    // 项目id
    private String subjectid;

    // 图片
    private String image;

    // 图片宽高
    private String imageSize;

    // 图片大小
    private String imageByte;

    // 内容
    private String content;

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

    public String getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(String subjectid) {
        this.subjectid = subjectid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageSize() {
        return imageSize;
    }

    public void setImageSize(String imageSize) {
        this.imageSize = imageSize;
    }

    public String getImageByte() {
        return imageByte;
    }

    public void setImageByte(String imageByte) {
        this.imageByte = imageByte;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
