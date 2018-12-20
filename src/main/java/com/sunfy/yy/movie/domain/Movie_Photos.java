package com.sunfy.yy.movie.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 影视剧照
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(uniqueConstraints = {@UniqueConstraint(columnNames={"subject_id","photos_id"})})
public class Movie_Photos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    //影视id
    @Column(name = "SUBJECT_ID",columnDefinition = "varchar(128) comment '影视id'")
    private String subjectid;

    //剧照ID
    @Column(name = "PHOTOS_ID",columnDefinition = "varchar(128) comment '剧照ID'")
    private String photosid;

    //剧照总数
    private String photos_total;

    //剧照总数
    private String photos_count;

    //
    private String photos_thumb;

    //
    private String photos_icon;

    //上传用户id
    private String photos_author_id;

    //上传时间
    private String photos_created_at;

    //相册id
    private String photos_album_id;

    //
    private String photos_cover;

    //上一张id
    private String photos_prev_photo;

    //下一张id
    private String photos_next_photo;

    //剧照相册链接
    private String photos_album_url;

    //剧照评论数
    private String photos_comments_count;

    //剧照链接
    private String photos_image;

    //剧照推荐人数
    private String photos_recs_count;

    //剧照位置
    private String photos_position;

    //豆瓣链接
    private String photos_alt;

    //相册名称
    private String photos_album_title;

    //
    private String photos_desc;

    //剧照方向横1竖2
    private String photos_direction;

    //剧照尺寸（宽X高）
    private String photos_size;

    //创建时间
    @CreatedDate
    private String createtime;

    //更新时间
    @LastModifiedDate
    private String updatetime;

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

    public String getPhotosid() {
        return photosid;
    }

    public void setPhotosid(String photosid) {
        this.photosid = photosid;
    }

    public String getPhotos_total() {
        return photos_total;
    }

    public void setPhotos_total(String photos_total) {
        this.photos_total = photos_total;
    }

    public String getPhotos_count() {
        return photos_count;
    }

    public void setPhotos_count(String photos_count) {
        this.photos_count = photos_count;
    }

    public String getPhotos_thumb() {
        return photos_thumb;
    }

    public void setPhotos_thumb(String photos_thumb) {
        this.photos_thumb = photos_thumb;
    }

    public String getPhotos_icon() {
        return photos_icon;
    }

    public void setPhotos_icon(String photos_icon) {
        this.photos_icon = photos_icon;
    }

    public String getPhotos_author_id() {
        return photos_author_id;
    }

    public void setPhotos_author_id(String photos_author_id) {
        this.photos_author_id = photos_author_id;
    }

    public String getPhotos_created_at() {
        return photos_created_at;
    }

    public void setPhotos_created_at(String photos_created_at) {
        this.photos_created_at = photos_created_at;
    }

    public String getPhotos_album_id() {
        return photos_album_id;
    }

    public void setPhotos_album_id(String photos_album_id) {
        this.photos_album_id = photos_album_id;
    }

    public String getPhotos_cover() {
        return photos_cover;
    }

    public void setPhotos_cover(String photos_cover) {
        this.photos_cover = photos_cover;
    }

    public String getPhotos_prev_photo() {
        return photos_prev_photo;
    }

    public void setPhotos_prev_photo(String photos_prev_photo) {
        this.photos_prev_photo = photos_prev_photo;
    }

    public String getPhotos_next_photo() {
        return photos_next_photo;
    }

    public void setPhotos_next_photo(String photos_next_photo) {
        this.photos_next_photo = photos_next_photo;
    }

    public String getPhotos_album_url() {
        return photos_album_url;
    }

    public void setPhotos_album_url(String photos_album_url) {
        this.photos_album_url = photos_album_url;
    }

    public String getPhotos_comments_count() {
        return photos_comments_count;
    }

    public void setPhotos_comments_count(String photos_comments_count) {
        this.photos_comments_count = photos_comments_count;
    }

    public String getPhotos_image() {
        return photos_image;
    }

    public void setPhotos_image(String photos_image) {
        this.photos_image = photos_image;
    }

    public String getPhotos_recs_count() {
        return photos_recs_count;
    }

    public void setPhotos_recs_count(String photos_recs_count) {
        this.photos_recs_count = photos_recs_count;
    }

    public String getPhotos_position() {
        return photos_position;
    }

    public void setPhotos_position(String photos_position) {
        this.photos_position = photos_position;
    }

    public String getPhotos_alt() {
        return photos_alt;
    }

    public void setPhotos_alt(String photos_alt) {
        this.photos_alt = photos_alt;
    }

    public String getPhotos_album_title() {
        return photos_album_title;
    }

    public void setPhotos_album_title(String photos_album_title) {
        this.photos_album_title = photos_album_title;
    }

    public String getPhotos_desc() {
        return photos_desc;
    }

    public void setPhotos_desc(String photos_desc) {
        this.photos_desc = photos_desc;
    }

    public String getPhotos_direction() {
        return photos_direction;
    }

    public void setPhotos_direction(String photos_direction) {
        this.photos_direction = photos_direction;
    }

    public String getPhotos_size() {
        return photos_size;
    }

    public void setPhotos_size(String photos_size) {
        this.photos_size = photos_size;
    }
}
