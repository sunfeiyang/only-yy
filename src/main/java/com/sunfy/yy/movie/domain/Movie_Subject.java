package com.sunfy.yy.movie.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 影视标签
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Movie_Subject {

    @Id
    @GeneratedValue
    private Integer tid;

    //影视id
    private String subject_id;

    //评价数
    private String subject_ratings_count;

    //长评数
    private String subject_reviews_count;

    //短评数
    private String subject_comments_count;

    //想看人数
    private String subject_wish_count;

    //看过人数
    private String subject_collect_count;

    //影视名称
    private String subject_title;

    //原名称
    private String subject_original_title;

    //别名
    private String subject_aka;

    //片长
    private String subject_durations;

    //年份
    private String subject_year;

    //语言
    private String subject_languages;

    //国别
    private String subject_countries;

    //上映日期
    private String subject_pubdate;

    //类别
    private String subject_genres;

    //是否正片
    private String subject_has_video;

    //海报地址
    private String subject_images;

    //豆瓣链接
    private String subject_alt;

    //移动端地址
    private String subject_mobile_url;

    //剧照数
    private String subject_photos_count;

    //类型
    private String subject_subtype;

    //折扣
    private String subject_do_count;

    //分享链接
    private String subject_share_url;

    //赛季数
    private String SUBJECT_SEASONS_COUNT;

    //预定url
    private String subject_schedule_url;

    //网站
    private String subject_website;

    //是否排片
    private String subject_has_schedule;

    //
    private String subject_collection;

    //
    private String subject_episodes_count;

    //是否有票
    private String subject_has_ticket;

    //本季度
    private String subject_current_season;

    //大陆上映日期
    private String subject_mainland_pubdate;

    //豆瓣网站
    private String subject_douban_site;

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

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_ratings_count() {
        return subject_ratings_count;
    }

    public void setSubject_ratings_count(String subject_ratings_count) {
        this.subject_ratings_count = subject_ratings_count;
    }

    public String getSubject_reviews_count() {
        return subject_reviews_count;
    }

    public void setSubject_reviews_count(String subject_reviews_count) {
        this.subject_reviews_count = subject_reviews_count;
    }

    public String getSubject_comments_count() {
        return subject_comments_count;
    }

    public void setSubject_comments_count(String subject_comments_count) {
        this.subject_comments_count = subject_comments_count;
    }

    public String getSubject_wish_count() {
        return subject_wish_count;
    }

    public void setSubject_wish_count(String subject_wish_count) {
        this.subject_wish_count = subject_wish_count;
    }

    public String getSubject_collect_count() {
        return subject_collect_count;
    }

    public void setSubject_collect_count(String subject_collect_count) {
        this.subject_collect_count = subject_collect_count;
    }

    public String getSubject_title() {
        return subject_title;
    }

    public void setSubject_title(String subject_title) {
        this.subject_title = subject_title;
    }

    public String getSubject_original_title() {
        return subject_original_title;
    }

    public void setSubject_original_title(String subject_original_title) {
        this.subject_original_title = subject_original_title;
    }

    public String getSubject_aka() {
        return subject_aka;
    }

    public void setSubject_aka(String subject_aka) {
        this.subject_aka = subject_aka;
    }

    public String getSubject_durations() {
        return subject_durations;
    }

    public void setSubject_durations(String subject_durations) {
        this.subject_durations = subject_durations;
    }

    public String getSubject_year() {
        return subject_year;
    }

    public void setSubject_year(String subject_year) {
        this.subject_year = subject_year;
    }

    public String getSubject_languages() {
        return subject_languages;
    }

    public void setSubject_languages(String subject_languages) {
        this.subject_languages = subject_languages;
    }

    public String getSubject_countries() {
        return subject_countries;
    }

    public void setSubject_countries(String subject_countries) {
        this.subject_countries = subject_countries;
    }

    public String getSubject_pubdate() {
        return subject_pubdate;
    }

    public void setSubject_pubdate(String subject_pubdate) {
        this.subject_pubdate = subject_pubdate;
    }

    public String getSubject_genres() {
        return subject_genres;
    }

    public void setSubject_genres(String subject_genres) {
        this.subject_genres = subject_genres;
    }

    public String getSubject_has_video() {
        return subject_has_video;
    }

    public void setSubject_has_video(String subject_has_video) {
        this.subject_has_video = subject_has_video;
    }

    public String getSubject_images() {
        return subject_images;
    }

    public void setSubject_images(String subject_images) {
        this.subject_images = subject_images;
    }

    public String getSubject_alt() {
        return subject_alt;
    }

    public void setSubject_alt(String subject_alt) {
        this.subject_alt = subject_alt;
    }

    public String getSubject_mobile_url() {
        return subject_mobile_url;
    }

    public void setSubject_mobile_url(String subject_mobile_url) {
        this.subject_mobile_url = subject_mobile_url;
    }

    public String getSubject_photos_count() {
        return subject_photos_count;
    }

    public void setSubject_photos_count(String subject_photos_count) {
        this.subject_photos_count = subject_photos_count;
    }

    public String getSubject_subtype() {
        return subject_subtype;
    }

    public void setSubject_subtype(String subject_subtype) {
        this.subject_subtype = subject_subtype;
    }

    public String getSubject_do_count() {
        return subject_do_count;
    }

    public void setSubject_do_count(String subject_do_count) {
        this.subject_do_count = subject_do_count;
    }

    public String getSubject_share_url() {
        return subject_share_url;
    }

    public void setSubject_share_url(String subject_share_url) {
        this.subject_share_url = subject_share_url;
    }

    public String getSUBJECT_SEASONS_COUNT() {
        return SUBJECT_SEASONS_COUNT;
    }

    public void setSUBJECT_SEASONS_COUNT(String SUBJECT_SEASONS_COUNT) {
        this.SUBJECT_SEASONS_COUNT = SUBJECT_SEASONS_COUNT;
    }

    public String getSubject_schedule_url() {
        return subject_schedule_url;
    }

    public void setSubject_schedule_url(String subject_schedule_url) {
        this.subject_schedule_url = subject_schedule_url;
    }

    public String getSubject_website() {
        return subject_website;
    }

    public void setSubject_website(String subject_website) {
        this.subject_website = subject_website;
    }

    public String getSubject_has_schedule() {
        return subject_has_schedule;
    }

    public void setSubject_has_schedule(String subject_has_schedule) {
        this.subject_has_schedule = subject_has_schedule;
    }

    public String getSubject_collection() {
        return subject_collection;
    }

    public void setSubject_collection(String subject_collection) {
        this.subject_collection = subject_collection;
    }

    public String getSubject_episodes_count() {
        return subject_episodes_count;
    }

    public void setSubject_episodes_count(String subject_episodes_count) {
        this.subject_episodes_count = subject_episodes_count;
    }

    public String getSubject_has_ticket() {
        return subject_has_ticket;
    }

    public void setSubject_has_ticket(String subject_has_ticket) {
        this.subject_has_ticket = subject_has_ticket;
    }

    public String getSubject_current_season() {
        return subject_current_season;
    }

    public void setSubject_current_season(String subject_current_season) {
        this.subject_current_season = subject_current_season;
    }

    public String getSubject_mainland_pubdate() {
        return subject_mainland_pubdate;
    }

    public void setSubject_mainland_pubdate(String subject_mainland_pubdate) {
        this.subject_mainland_pubdate = subject_mainland_pubdate;
    }

    public String getSubject_douban_site() {
        return subject_douban_site;
    }

    public void setSubject_douban_site(String subject_douban_site) {
        this.subject_douban_site = subject_douban_site;
    }
}
