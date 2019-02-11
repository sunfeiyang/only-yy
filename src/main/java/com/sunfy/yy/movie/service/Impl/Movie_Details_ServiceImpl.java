package com.sunfy.yy.movie.service.Impl;

import com.sunfy.yy.common.enums.EnumApi;
import com.sunfy.yy.common.enums.EnumPath;
import com.sunfy.yy.common.utils.*;
import com.sunfy.yy.movie.domain.*;
import com.sunfy.yy.movie.repository.*;
import com.sunfy.yy.movie.service.Movie_Details_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class Movie_Details_ServiceImpl extends Movie_ServiceImpl implements Movie_Details_Service {

    private static final Logger logger = LoggerFactory.getLogger(Movie_Details_ServiceImpl.class);

    @Autowired
    private Movie_Subject_Repository movie_subject_repository;

    @Autowired
    private Movie_Rat_Repository movie_rat_repository;

    @Autowired
    private Movie_Countries_Repository movie_countries_repository;

    @Autowired
    private Movie_Durations_Repository movie_durations_repository;

    @Autowired
    private Movie_Genres_Repository movie_genres_repository;

    @Autowired
    private Movie_Languages_Repository movie_languages_repository;

    @Autowired
    private Movie_Pubdate_Repository movie_pubdate_repository;

    @Autowired
    private Movie_Tags_Repository movie_tags_repository;

    @Autowired
    private Movie_Year_Repository movie_year_repository;

    @Autowired
    private Movie_Comments_Repository movie_comments_repository;

    @Autowired
    private Movie_Reviews_Repository movie_reviews_repository;

    @Autowired
    private Movie_Author_Repository movie_author_repository;

    @Autowired
    private Movie_Photos_Repository movie_photos_repository;

    @Autowired
    private Movie_Images_Repository movie_images_repository;

    @Autowired
    private Movie_Prevue_Repository movie_prevue_repository;

    @Autowired
    private Movie_Video_Repository movie_video_repository;

    @Autowired
    private Movie_Casts_Repository movie_casts_repository;

    UtilsJson jsonUtils = new UtilsJson();

    @Override
    public ArrayList setSubjectDetails(String subjectID) {
        if(logger.isInfoEnabled()){
            logger.info("【Movie_Details_ServiceImpl—setSubjectDetails】请求成功！");
        }
        //定义返回对象
        ArrayList result_list = new ArrayList();
        //数据请求结果
        String jsonResult = HttpRequest.get(EnumApi.M_SUBJECT.getURL()+"/"+subjectID);
        Map map = null;
        try {
            //当网络异常时，获取数据为null，此时随机从现有数据中随机生成一条返回
            if (jsonResult == "" || jsonResult == null) {
//                throw new ExceptionCulture(EnumCultureException.NETWORKANOMALY);
                logger.info("【请求数据为空】");
            } else {
                map = jsonUtils.toMap(jsonResult);
                String id = map.get("id")+ "";
                Map rating = (Map) map.get("rating");
                // 评分数值
                String rat_average = map.get("average") + "";
                String ratings_count = map.get("ratings_count")+ "";
                // 评分详情插入
                this.setRat(rating,id,ratings_count);

                String reviews_count = map.get("reviews_count") + "";
                ArrayList videos = (ArrayList)map.get("videos");
                // 写入资源
                this.setVideo(videos,id);

                String wish_count = map.get("wish_count") + "";
                String original_title = map.get("original_title")+ "";
                ArrayList blooper_urls = (ArrayList)map.get("blooper_urls");

                String year = map.get("year")+ "";
                // 写入年份
                this.setYear(year,id);

                String collect_count = map.get("collect_count")+ "";
                Map images = (Map)map.get("images");
                // 写入海报
                this.setImages(images,id,year);

                String douban_site = map.get("douban_site")+ "";

                ArrayList popular_comments = (ArrayList)map.get("popular_comments");
                // 写入短评
//                this.setComments_url(id);

                String alt = map.get("alt")+ "";
                String mobile_url = map.get("mobile_url")+ "";
                String photos_count = map.get("photos_count")+ "";
                String pubdate = map.get("pubdate")+ "";
                String title = map.get("title")+ "";
                String do_count = map.get("do_count") + "";
                String has_video = map.get("has_video")+ "";
                String share_url = map.get("share_url")+ "";
                String seasons_count = map.get("seasons_count")+ "";
                ArrayList languages = (ArrayList)map.get("languages");
                // 写入语言
                this.setLanguages(languages,id);

                String schedule_url = map.get("schedule_url")+ "";

                ArrayList directors = (ArrayList)map.get("directors");
                // 写入导演
                this.setCasts(directors,id,"1");
                ArrayList writers = (ArrayList)map.get("writers");
                // 写入编剧
                this.setCasts(writers,id,"2");
                ArrayList casts = (ArrayList)map.get("casts");
                // 写入演员
                this.setCasts(casts,id,"3");

                ArrayList pubdates = (ArrayList)map.get("pubdates");
                // 写入上映日期
                this.setPubdates(pubdates,id);

                String website = map.get("website")+ "";
                ArrayList tags = (ArrayList)map.get("tags");
                //写入标签
                this.setTags(tags,id);
                //通过url查询影片的标签 并写入数据
//                this.setTags_url(id);

                String has_schedule = map.get("has_schedule")+ "";
                ArrayList durations = (ArrayList)map.get("durations");
                // 写入时长
                this.setDurations(durations,id);

                ArrayList genres = (ArrayList)map.get("genres");
                //写入影视类别
                this.setGeners(genres,id);

                String collection = map.get("collection")+ "";
                ArrayList trailers = (ArrayList)map.get("trailers");
                // 写入资源预告片
                this.setPrevue(trailers);

                String episodes_count = map.get("episodes_count")+ "";
                ArrayList trailer_urls = (ArrayList)map.get("trailer_urls");
                String has_ticket = map.get("has_ticket")+ "";
                ArrayList bloopers = (ArrayList)map.get("bloopers");
                // 写入资源预告片
                this.setPrevue(bloopers);

                ArrayList clip_urls = (ArrayList)map.get("clip_urls");
                String current_season = map.get("current_season")+ "";

                ArrayList countries = (ArrayList)map.get("countries");
                // 插入国别
                this.setCountries(countries,id);

                String mainland_pubdate = map.get("mainland_pubdate")+ "";
                ArrayList photos = (ArrayList)map.get("photos");
                // 写入剧照
//                this.setPhotos_url(id);

                String summary = map.get("summary")+ "";
                ArrayList clips = (ArrayList)map.get("clips");
                // 写入资源预告片
                this.setPrevue(clips);

                String subtype = map.get("subtype")+ "";

                String comments_count = map.get("comments_count")+ "";
                ArrayList popular_reviews = (ArrayList)map.get("popular_reviews");
                // 写入长评
//                this.setReviews_url(id);

                ArrayList aka = (ArrayList)map.get("aka");

                Movie_Subject movie_subject = new Movie_Subject();
                movie_subject.setSubjectid(id);
                movie_subject.setSubject_ratings_count(ratings_count);
                movie_subject.setSubject_reviews_count(reviews_count);
                movie_subject.setSubject_comments_count(comments_count);
                movie_subject.setSubject_wish_count(wish_count);
                movie_subject.setSubject_collect_count(collect_count);
                movie_subject.setSubject_title(title);
                movie_subject.setSubject_original_title(original_title);
                movie_subject.setSubject_aka(aka.toString());
                movie_subject.setSubject_durations(durations.toString());
                movie_subject.setSubject_year(year);
                movie_subject.setSubject_languages(languages.toString());
                movie_subject.setSubject_countries(countries.toString());
                movie_subject.setSubject_pubdate(pubdate);
                movie_subject.setSubject_genres(genres.toString());
                movie_subject.setSubject_has_video(has_video);
//                movie_subject.setSubject_images(images);
                movie_subject.setSubject_alt(alt);
                movie_subject.setSubject_mobile_url(mobile_url);
                movie_subject.setSubject_photos_count(photos_count);
                movie_subject.setSubject_subtype(subtype);
                movie_subject.setSubject_do_count(do_count);
                movie_subject.setSubject_share_url(share_url);
                movie_subject.setSubject_seasons_count(seasons_count);
                movie_subject.setSubject_schedule_url(schedule_url);
                movie_subject.setSubject_website(website);
                movie_subject.setSubject_has_schedule(has_schedule);
                movie_subject.setSubject_collection(collection);
                movie_subject.setSubject_episodes_count(episodes_count);
                movie_subject.setSubject_has_ticket(has_ticket);
                movie_subject.setSubject_current_season(current_season);
                movie_subject.setSubject_mainland_pubdate(mainland_pubdate);
                movie_subject.setSubject_douban_site(douban_site);
                movie_subject.setSubject_rat(rat_average);

                result_list = movie_subject_repository.findBySubjectid(id);
                if(result_list != null && result_list.size() > 0){
                    return result_list;
                }else{
                    result_list.add(movie_subject_repository.save(movie_subject));
                }
            }
            return result_list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result_list;
    }

    /**
     * 访问url请求影视的标签
     * @param subjectID
     */
    @Override
    public void setTags_url(String subjectID){
        if(logger.isInfoEnabled()){
            logger.info("【Movie_Details_ServiceImpl—setTags_url】请求成功！");
        }
        String jsonResult = HttpRequest.get(EnumApi.M_SUBJECT.getURL()+"/"+subjectID+"/tags");
        Map map = null;
        if(jsonResult =="" || jsonResult == null){
            logger.info("【标签】——【请求数据为空】");
        }else{
            try {
                map = jsonUtils.toMap(jsonResult);
                String id = map.get("id")+ "";
                ArrayList tags = (ArrayList) map.get("tags");
                this.setTags(tags,id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 访问url请求影视的短评
     * @param subjectID
     */
    @Override
    public void setComments_url(String subjectID){
        if(logger.isInfoEnabled()){
            logger.info("【Movie_Details_ServiceImpl—setComments_url】请求成功！");
        }
        String jsonResult = HttpRequest.get(EnumApi.M_SUBJECT.getURL()+"/"+subjectID+"/comments");
        Map map = null;
        if(jsonResult =="" || jsonResult == null){
            logger.info("【短评】——【请求数据为空】");
        }else{
            try {
                map = jsonUtils.toMap(jsonResult);
                ArrayList comments = (ArrayList) map.get("comments");
                String total = map.get("total") + "";
                for (int i = 0; i < comments.size(); i++) {
                    Map Map_comments = (Map) comments.get(i);
                    // 评论的评星等级
                    Map rating = (Map)Map_comments.get("rating");
                    String rating_max = rating.get("max") + "";
                    String rating_value = rating.get("value") + "";
                    String rating_min = rating.get("min") + "";
                    String useful_count = Map_comments.get("useful_count") + "";
                    // 评论人相关信息
                    Map author = (Map)Map_comments.get("author");
                    String author_id = author.get("id") + "";
                    this.setAuthor(author);

                    String subject_id = Map_comments.get("subject_id") + "";
                    String content = Map_comments.get("content") + "";
                    String created_at = Map_comments.get("created_at") + "";
                    // 评论id
                    String id = Map_comments.get("id") + "";

                    Movie_Comments movie_comments = new Movie_Comments();
                    movie_comments.setSubjectid(subject_id);
                    movie_comments.setCommentsid(id);
                    movie_comments.setComments_rating_max(rating_max);
                    movie_comments.setComments_rating_min(rating_min);
                    movie_comments.setComments_rating_value(rating_value);
                    movie_comments.setComments_useful_count(useful_count);
                    movie_comments.setComments_author_id(author_id);
                    movie_comments.setComments_content(content);
                    movie_comments.setComments_created_at(created_at);
                    movie_comments.setComments_total(total);

                    ArrayList result = movie_comments_repository.findByCommentsidAndSubjectid(id,subjectID);
                    if(result != null && result.size() > 0){
                        logger.info("影片【短评】已存在！");
                    }else{
                        movie_comments_repository.save(movie_comments);
                        logger.info("成功插入影片【短评】");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 访问url请求影视的长评
     * @param subjectID
     */
    @Override
    public void setReviews_url(String subjectID){
        if(logger.isInfoEnabled()){
            logger.info("【Movie_Details_ServiceImpl—setReviews_url】请求成功！");
        }
        String jsonResult = HttpRequest.get(EnumApi.M_SUBJECT.getURL()+"/"+subjectID+"/reviews");
        Map map = null;
        if(jsonResult =="" || jsonResult == null){
            logger.info("【长评】——【请求数据为空】");
        }else{
            try {
                map = jsonUtils.toMap(jsonResult);
                String total = map.get("total") + "";
                ArrayList reviews = (ArrayList) map.get("reviews");
                for (int i = 0; i < reviews.size(); i++) {
                    Map Map_reviews = (Map) reviews.get(i);
                    // 评论的评星等级
                    Map rating = (Map) Map_reviews.get("rating");
                    String rating_max = rating.get("max") + "";
                    String rating_value = rating.get("value") + "";
                    String rating_min = rating.get("min") + "";
                    String useful_count = Map_reviews.get("useful_count") + "";
                    String useless_count = Map_reviews.get("useless_count") + "";
                    // 评论人相关信息
                    Map author = (Map) Map_reviews.get("author");
                    String author_id = author.get("id") + "";
                    this.setAuthor(author);

                    String created_at = Map_reviews.get("created_at") + "";
                    String updated_at = Map_reviews.get("updated_at") + "";
                    String title = Map_reviews.get("title") + "";
                    String share_url = Map_reviews.get("share_url") + "";
                    String subject_id = Map_reviews.get("subject_id") + "";
                    String content = Map_reviews.get("content") + "";
                    String summary = Map_reviews.get("summary") + "";
                    String comments_count = Map_reviews.get("comments_count") + "";
                    String alt = Map_reviews.get("alt") + "";
                    // 评论id
                    String id = Map_reviews.get("id") + "";

                    Movie_Reviews movie_reviews = new Movie_Reviews();
                    movie_reviews.setSubjectid(subject_id);
                    movie_reviews.setReviewsid(id);
                    movie_reviews.setReviews_rating_max(rating_max);
                    movie_reviews.setReviews_rating_min(rating_min);
                    movie_reviews.setReviews_rating_value(rating_value);
                    movie_reviews.setReviews_useful_count(useful_count);
                    movie_reviews.setReviews_useless_count(useless_count);
                    movie_reviews.setReviews_author_id(author_id);
                    movie_reviews.setReviews_created_at(created_at);
                    movie_reviews.setReviews_updated_at(updated_at);
                    movie_reviews.setReviews_title(title);
                    movie_reviews.setReviews_summary(summary);
                    movie_reviews.setReviews_content(content);
                    movie_reviews.setReviews_alt(alt);
                    movie_reviews.setReviews_comments_count(comments_count);
                    movie_reviews.setReviews_share_url(share_url);
                    movie_reviews.setReviews_total(total);

                    ArrayList result = movie_reviews_repository.findByReviewsidAndSubjectid(id, subjectID);
                    if (result != null && result.size() > 0) {
                        logger.info("影片【长评】已存在！");
                    } else {
                        movie_reviews_repository.save(movie_reviews);
                        logger.info("成功插入影片【长评】");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 访问url请求影视的剧照
     * 【剧照数据的保存文件是在image文件夹下每个对应的subject_id文件夹下，与封面保存在年份文件夹下不同】
     * @param subjectID
     */
    public void setPhotos_url(String subjectID){
        if(logger.isInfoEnabled()){
            logger.info("【Movie_Details_ServiceImpl—setPhotos_url】请求成功！");
        }
        String jsonResult = HttpRequest.get(EnumApi.M_SUBJECT.getURL()+"/"+subjectID+"/photos?start=0&count=50");
        Map map = null;
        if(jsonResult =="" || jsonResult == null){
            logger.info("【剧照】——【请求数据为空】");
        }else{
            try {
                map = jsonUtils.toMap(jsonResult);
                ArrayList photos = (ArrayList) map.get("photos");
                String total = map.get("total") + "";
                for (int i = 0; i < photos.size(); i++) {
                    Map Map_photos = (Map) photos.get(i);
                    String photos_count = Map_photos.get("photos_count") + "";
                    String thumb = Map_photos.get("thumb") + "";
                    String icon = Map_photos.get("icon") + "";
                    Map author = (Map) Map_photos.get("author");
                    // 评论人相关信息
                    String author_id = author.get("id") + "";
                    this.setAuthor(author);

                    String created_at = Map_photos.get("created_at") + "";
                    String album_id = Map_photos.get("album_id") + "";
                    String cover = Map_photos.get("cover") + "";
                    String id = Map_photos.get("id") + "";
                    String prev_photo = Map_photos.get("prev_photo") + "";
                    String album_url = Map_photos.get("album_url") + "";
                    String comments_count = Map_photos.get("comments_count") + "";
                    String image = Map_photos.get("image") + "";
                    String recs_count = Map_photos.get("recs_count") + "";
                    String position = Map_photos.get("position") + "";
                    String alt = Map_photos.get("alt") + "";
                    String album_title = Map_photos.get("album_title") + "";
                    String next_photo = Map_photos.get("next_photo") + "";
                    String subject_id = Map_photos.get("subject_id") + "";
                    String desc = Map_photos.get("desc") + "";

                    Movie_Photos movie_photos = new Movie_Photos();
                    movie_photos.setSubjectid(subject_id);
                    movie_photos.setPhotosid(id);
                    movie_photos.setPhotos_total(total);
                    movie_photos.setPhotos_count(photos_count);

                    // 将图片文件保存到本地（对应的subject_id文件夹下）
                    String saveImageName_thumb = System.currentTimeMillis() + ".jpg";
                    UtilsDownloadImage.download(thumb,saveImageName_thumb, EnumPath.BASHPATH.getValue() + "image/" + subject_id);
                    movie_photos.setPhotos_thumb(subject_id+"/"+saveImageName_thumb);

                    // 将图片文件保存到本地（对应的subject_id文件夹下）
                    String saveImageName_icon = System.currentTimeMillis() + ".jpg";
                    UtilsDownloadImage.download(icon,saveImageName_icon, EnumPath.BASHPATH.getValue() + "image/" + subject_id);
                    movie_photos.setPhotos_icon(subject_id+"/"+saveImageName_icon);

                    movie_photos.setPhotos_author_id(author_id);
                    movie_photos.setPhotos_created_at(created_at);
                    movie_photos.setPhotos_album_id(album_id);

                    // 将图片文件保存到本地（对应的subject_id文件夹下）
                    String saveImageName_cover = System.currentTimeMillis() + ".jpg";
                    UtilsDownloadImage.download(cover,saveImageName_cover, EnumPath.BASHPATH.getValue() + "image/" + subject_id);
                    movie_photos.setPhotos_cover(subject_id+"/"+saveImageName_cover);

                    movie_photos.setPhotos_prev_photo(prev_photo);
                    movie_photos.setPhotos_next_photo(next_photo);
                    movie_photos.setPhotos_album_url(album_url);
                    movie_photos.setPhotos_comments_count(comments_count);

                    // 将图片文件保存到本地（对应的subject_id文件夹下）
                    String saveImageName_image = System.currentTimeMillis() + ".jpg";
                    UtilsDownloadImage.download(image,saveImageName_image, EnumPath.BASHPATH.getValue() + "image/" + subject_id);
                    movie_photos.setPhotos_image(subject_id+"/"+saveImageName_image);

                    movie_photos.setPhotos_recs_count(recs_count);
                    movie_photos.setPhotos_position(position);
                    movie_photos.setPhotos_alt(alt);
                    movie_photos.setPhotos_album_title(album_title);
                    movie_photos.setPhotos_desc(desc);

                    // 获取图片的方向和尺寸进行保存
                    Map map_photosDetails = UtilsImageDetails.getImageDetails(EnumPath.BASHPATH.getValue() + "image/" + subject_id+"/"+saveImageName_image);
                    String ImageWidth = (String) map_photosDetails.get("Image Width");
                    String ImageHeight = (String) map_photosDetails.get("Image Height");
                    if(Integer.parseInt(ImageWidth.split(" ")[0]) > Integer.parseInt(ImageHeight.split(" ")[0])){
                        // 剧照方向横1竖2
                        movie_photos.setPhotos_direction("1");
                    }else{
                        movie_photos.setPhotos_direction("2");
                    }
                    movie_photos.setPhotos_size(ImageWidth.split(" ")[0]+" x "+ImageHeight.split(" ")[0]);


                    ArrayList result = movie_photos_repository.findByPhotosidAndSubjectid(id,subjectID);
                    if(result != null && result.size() > 0){
                        logger.info("影片【剧照】已存在！");
                    }else{
                        movie_photos_repository.save(movie_photos);
                        logger.info("成功插入影片【剧照】");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 插入评分
     * @param map 待写入数据
     * @param subjectID 写入影视ID
     * @param ratings_count 总的评分数
     */
    public void setRat(Map map,String subjectID,String ratings_count){
        ArrayList result = movie_rat_repository.findBySubjectid(subjectID);
        if(result != null && result.size() > 0){
            logger.info("影片【评分】已存在！");
        }else{
            String rat_max = map.get("max")+ "";
            String rat_average = map.get("average")+ "";
            Map rat_details = (Map) map.get("details");
            String rat_details_1 = rat_details.get("1") + "";
            String rat_details_2 = rat_details.get("2") + "";
            String rat_details_3 = rat_details.get("3") + "";
            String rat_details_4 = rat_details.get("4") + "";
            String rat_details_5 = rat_details.get("5") + "";
            String rat_stars = map.get("stars")+ "";
            String rat_min = map.get("min")+ "";

            Movie_Rat movie_rat = new Movie_Rat();
            movie_rat.setSubjectid(subjectID);
            movie_rat.setRat_average(rat_average);
            movie_rat.setRat_total(ratings_count);
            movie_rat.setRat_details1(rat_details_1);
            movie_rat.setRat_details2(rat_details_2);
            movie_rat.setRat_details3(rat_details_3);
            movie_rat.setRat_details4(rat_details_4);
            movie_rat.setRat_details5(rat_details_5);
            movie_rat.setRat_max(rat_max);
            movie_rat.setRat_min(rat_min);
            movie_rat.setRat_stars(rat_stars);
            movie_rat_repository.save(movie_rat);
            logger.info("成功插入影片【评分】");
        }

    }

    /**
     * 写入国别
     * @param list 待写入国别数据
     * @param subjectID 写入影视ID
     */
    public void setCountries(ArrayList list,String subjectID){
        if(list != null && list.size() > 0){
            for (int i = 0; i < list.size(); i++) {
                ArrayList result = movie_countries_repository.findBySubjectidAndCountriesval(subjectID,list.get(i) + "");
                if(result != null && result.size() > 0){
                    logger.info("影片【国别】已存在！");
                }else{
                    Movie_Countries movie_countries = new Movie_Countries();
                    movie_countries.setSubjectid(subjectID);
                    movie_countries.setCountriesval(list.get(i) + "");
                    movie_countries_repository.save(movie_countries);
                    logger.info("成功插入影片【国别】");
                }
            }
        }
    }

    /**
     * 写入标签
     * @param list 待写入标签数据
     * @param subjectID 写入影视ID
     */
    public void setTags(ArrayList list,String subjectID){
        if(list != null && list.size() > 0){
            for (int i = 0; i < list.size(); i++) {
                Movie_Tags movie_tags = new Movie_Tags();
                movie_tags.setSubjectid(subjectID);
                movie_tags.setTagsval(list.get(i) + "");
                Movie_Tags result = movie_tags_repository.findBySubjectidAndTagsval(subjectID,list.get(i) + "");
                if(result != null){
                    logger.info("影片【标签】已存在！");
                    result.setTagsval("---"+list.get(i));
                    // TODO
                    // 根据当前的数据状态决定是否更新已有数据
                    logger.info("影片【标签】存在时更新！");
                }else{
                    movie_tags_repository.save(movie_tags);
                    logger.info("成功插入影片【标签】");
                }
            }
        }
    }

    /**
     * 写入影视类别
     * @param list 待写入影视类别数据
     * @param subjectID 写入影视ID
     */
    public void setGeners(ArrayList list,String subjectID){
        if(list != null && list.size() > 0){
            for (int i = 0; i < list.size(); i++) {
                ArrayList result = movie_genres_repository.findBySubjectidAndGenresval(subjectID,list.get(i) + "");
                if(result != null && result.size() > 0){
                    logger.info("影片【类别】已存在！");
                }else{
                    Movie_Genres movie_genres = new Movie_Genres();
                    movie_genres.setSubjectid(subjectID);
                    movie_genres.setGenresval(list.get(i) + "");
                    movie_genres_repository.save(movie_genres);
                    logger.info("成功插入影片【类别】");
                }
            }
        }
    }

    /**
     * 写入影视时长
     * @param list 待写入影视时长数据
     * @param subjectID 写入影视ID
     */
    public void setDurations(ArrayList list,String subjectID){
        if(list != null && list.size() > 0){
            for (int i = 0; i < list.size(); i++) {
                ArrayList result = movie_durations_repository.findBySubjectidAndDurationsval(subjectID,list.get(i) + "");
                if(result != null && result.size() > 0){
                    logger.info("影片【时长】已存在！");
                }else{
                    Movie_Durations movie_durations = new Movie_Durations();
                    movie_durations.setSubjectid(subjectID);
                    movie_durations.setDurationsval(list.get(i) + "");
                    movie_durations_repository.save(movie_durations);
                    logger.info("成功插入影片【时长】");
                }
            }
        }
    }

    /**
     * 写入影视上映日期
     * @param list 待写入上映日期数据
     * @param subjectID 写入影视ID
     */
    public void setPubdates(ArrayList list,String subjectID){
        if(list != null && list.size() > 0){
            for (int i = 0; i < list.size(); i++) {
                ArrayList result = movie_pubdate_repository.findBySubjectidAndPubdatedate(subjectID,list.get(i) + "");
                if(result != null && result.size() > 0){
                    logger.info("影片【上映日期】已存在！");
                }else{
                    Movie_Pubdate movie_pubdate = new Movie_Pubdate();
                    movie_pubdate.setSubjectid(subjectID);
                    movie_pubdate.setPubdatedate(list.get(i) + "");
                    movie_pubdate_repository.save(movie_pubdate);
                    logger.info("成功插入影片【上映日期】");
                }
            }
        }
    }

    /**
     * 写入影视语言
     * @param list 待写入上语言数据
     * @param subjectID 写入影视ID
     */
    public void setLanguages(ArrayList list,String subjectID){
        if(list != null && list.size() > 0){
            for (int i = 0; i < list.size(); i++) {
                ArrayList result = movie_languages_repository.findBySubjectidAndLanguagesval(subjectID,list.get(i) + "");
                if(result != null && result.size() > 0){
                    logger.info("影片【语言】已存在！");
                }else{
                    Movie_Languages movie_languages = new Movie_Languages();
                    movie_languages.setSubjectid(subjectID);
                    movie_languages.setLanguagesval(list.get(i) + "");
                    movie_languages_repository.save(movie_languages);
                    logger.info("成功插入影片【语言】");
                }
            }
        }
    }

    /**
     * 写入影视预告片
     * @param list 待写入上预告数据
     */
    public void setPrevue(ArrayList list){
        if(list != null && list.size() > 0){
            for (int i = 0; i < list.size(); i++) {
                Map map = (Map) list.get(i);
                String medium = map.get("medium") + "";
                String title = map.get("title") + "";
                String subject_id = map.get("subject_id") + "";
                String alt = map.get("alt") + "";
                String small = map.get("small") + "";
                String resource_url = map.get("resource_url") + "";
                String id = map.get("id") + "";
                ArrayList result = movie_prevue_repository.findByPrevueidAndSubjectid(id,subject_id);
                if(result != null && result.size() > 0){
                    logger.info("影片【预告片】已存在！");
                }else{
                    Movie_Prevue movie_prevue = new Movie_Prevue();
                    movie_prevue.setSubjectid(subject_id);
                    movie_prevue.setPrevueid(id);
                    movie_prevue.setPrevue_medium(medium);
                    movie_prevue.setPrevue_small(small);
                    movie_prevue.setPrevue_resource_url(resource_url);
                    movie_prevue.setPrevue_alt(alt);
                    movie_prevue.setPrevue_title(title);
                    movie_prevue_repository.save(movie_prevue);
                    logger.info("成功插入影片【预告片】");
                }
            }
        }
    }

    /**
     * 写入影视演职员
     * @param list 待写入上演职员数据
     * @param subject_id 写入影视ID
     * @param type 导演1、编剧2、演员3
     */
    public void setCasts(ArrayList list,String subject_id,String type){
        if(list != null && list.size() > 0){
            for (int i = 0; i < list.size(); i++) {
                Map map = (Map) list.get(i);
                Map avatars = (Map) map.get("avatars");
                String small = avatars.get("small") + "";
                String large = avatars.get("large") + "";
                String medium = avatars.get("medium") + "";
                String name_en = map.get("name_en") + "";
                String name = map.get("name") + "";
                String alt = map.get("alt") + "";
                String id = map.get("id") + "";ArrayList result = movie_casts_repository.findByCastsidAndSubjectid(id,subject_id);
                if(result != null && result.size() > 0){
                    logger.info("影片【演职员】已存在！");
                }else{
                    Movie_Casts movie_casts = new Movie_Casts();
                    movie_casts.setSubjectid(subject_id);
                    movie_casts.setCastsid(id);
                    movie_casts.setCasts_name(name);
                    movie_casts.setCasts_name_en(name_en);
                    movie_casts.setCasts_alt(alt);

                    // 将图片文件保存到本地（对应的subject_id文件夹下）
                    String saveImageName_large = System.currentTimeMillis() + ".jpg";
                    UtilsDownloadImage.download(large,saveImageName_large, EnumPath.BASHPATH.getValue() + "image/" + subject_id);
                    movie_casts.setCasts_avatars_large(subject_id+"/"+saveImageName_large);

                    // 将图片文件保存到本地（对应的subject_id文件夹下）
                    String saveImageName_small = System.currentTimeMillis() + ".jpg";
                    UtilsDownloadImage.download(small,saveImageName_small, EnumPath.BASHPATH.getValue() + "image/" + subject_id);
                    movie_casts.setCasts_avatars_small(subject_id+"/"+saveImageName_small);

                    // 将图片文件保存到本地（对应的subject_id文件夹下）
                    String saveImageName_medium = System.currentTimeMillis() + ".jpg";
                    UtilsDownloadImage.download(medium,saveImageName_medium, EnumPath.BASHPATH.getValue() + "image/" + subject_id);
                    movie_casts.setCasts_avatars_medium(subject_id+"/"+saveImageName_medium);

                    movie_casts.setCasts_type(type);

                    movie_casts_repository.save(movie_casts);
                    logger.info("成功插入影片【演职员】");
                }
            }
        }
    }

    /**
     * 写入影视资源
     * @param list 待写入上资源数据
     */
    public void setVideo(ArrayList list,String subject_id){
        if(list != null && list.size() > 0){
            for (int i = 0; i < list.size(); i++) {
                Map map = (Map) list.get(i);
                Map source = (Map)map.get("source");
                String literal = source.get("literal") + "";
                String pic = source.get("pic") + "";
                String name = source.get("name") + "";
                String sample_link = map.get("sample_link") + "";
                String video_id = map.get("video_id") + "";
                String need_pay = map.get("need_pay") + "";
                ArrayList result = movie_video_repository.findByVideoidAndSubjectid(video_id,subject_id);
                if(result != null && result.size() > 0){
                    logger.info("影片【资源】已存在！");
                }else{
                    Movie_Video movie_video = new Movie_Video();
                    movie_video.setSubjectid(subject_id);
                    movie_video.setVideoid(video_id);
                    movie_video.setVideo_source_literal(literal);
                    movie_video.setVideo_source_pic(pic);
                    movie_video.setVideo_source_name(name);
                    movie_video.setVideo_need_pay(need_pay);
                    movie_video.setVideo_sample_link(sample_link);
                    movie_video_repository.save(movie_video);
                    logger.info("成功插入影片【资源】");
                }
            }
        }
    }

    /**
     * 写入年份
     * @param str 待写入上语言数据
     * @param subjectID 写入影视ID
     */
    public void setYear(String str,String subjectID){
        if(str != null && str != ""){
            ArrayList result = movie_year_repository.findBySubjectidAndYearval(subjectID,str);
            if(result != null && result.size() > 0){
                logger.info("影片【年份】已存在！");
            }else{
                Movie_Year movie_year = new Movie_Year();
                movie_year.setSubjectid(subjectID);
                movie_year.setYearval(str);
                movie_year_repository.save(movie_year);
                logger.info("成功插入影片【年份】");
            }
        }
    }


    /**
     * 写入豆瓣用户
     * @param map 待写入用户数据
     */
    public void setAuthor(Map map){
        if(!map.isEmpty()){
            String uid = map.get("uid")+ "";
            String avatar = map.get("avatar")+ "";
            String signature = map.get("signature")+ "";
            String alt = map.get("alt")+ "";
            String id = map.get("id")+ "";
            String name = map.get("name")+ "";
            ArrayList result = movie_author_repository.findByAuthorid(id);
            if(result != null && result.size() > 0){
                logger.info("影片【用户】已存在！");
            }else{
                Movie_Author movie_author = new Movie_Author();
                movie_author.setAuthorid(id);
                movie_author.setAuthor_alt(alt);
                movie_author.setAuthor_avatar(avatar);
                movie_author.setAuthor_name(name);
                movie_author.setAuthor_signature(signature);
                movie_author.setAuthor_uid(uid);
                movie_author_repository.save(movie_author);
                logger.info("成功插入影片【用户】");
            }
        }
    }

    /**
     * 写入海报
     * @param map 待写入用户数据
     */
    public void setImages(Map map,String id,String year){
        if(!map.isEmpty()){
            String small = map.get("small")+ "";
            String large = map.get("large")+ "";
            String medium = map.get("medium")+ "";
            ArrayList result = movie_images_repository.findBySubjectid(id);
            if(result != null && result.size() > 0){
                logger.info("影片【海报】已存在！");
            }else{
                Movie_Images movie_images = new Movie_Images();
                movie_images.setSubjectid(id);
                // 将图片文件保存到本地
                String saveImageName_small = System.currentTimeMillis() + ".jpg";
                UtilsDownloadImage.download(small,saveImageName_small, EnumPath.BASHPATH.getValue() + "image/" + year);
                movie_images.setImages_small(year+"/"+saveImageName_small);
                // 将图片文件保存到本地
                String saveImageName_medium = System.currentTimeMillis() + ".jpg";
                UtilsDownloadImage.download(medium,saveImageName_medium, EnumPath.BASHPATH.getValue() + "image/" + year);
                movie_images.setImages_medium(year+"/"+saveImageName_medium);
                // 将图片文件保存到本地
                String saveImageName_large = System.currentTimeMillis() + ".jpg";
                UtilsDownloadImage.download(large,saveImageName_large, EnumPath.BASHPATH.getValue() + "image/" + year);
                movie_images.setImages_large(year+"/"+saveImageName_large);
                movie_images_repository.save(movie_images);
                logger.info("成功插入影片【海报】");
            }
        }
    }


    @Override
    public ArrayList getSubjectDetails(String subjectID) {
        if(logger.isInfoEnabled()){
            logger.info("【Movie_Details_ServiceImpl—getSubjectDetails】请求成功！");
        }
        //定义返回对象
        ArrayList result_list = movie_subject_repository.findBySubjectid(subjectID);
//        // 获取短评
//        ArrayList result_comments = movie_comments_repository.findBySubjectid(subjectID);
//        for (int i = 0; i < result_comments.size(); i++) {
//            Movie_Comments movie_comments = (Movie_Comments) result_comments.get(i);
//            ArrayList list_author = movie_author_repository.findByAuthorid(movie_comments.getComments_author_id());
//            movie_comments.setComments_movie_author(list_author);
//        }

        // 获取长评
//        ArrayList result_reviews = movie_reviews_repository.findBySubjectid(subjectID);
//        for (int i = 0; i < result_reviews.size(); i++) {
//            Movie_Reviews movie_reviews = (Movie_Reviews) result_reviews.get(i);
//            ArrayList list_author = movie_author_repository.findByAuthorid(movie_reviews.getReviews_author_id());
//            movie_reviews.setReviews_movie_author(list_author);
//        }

        // 获取演职员
        ArrayList result_casts = movie_casts_repository.findBySubjectid(subjectID);

        // 获取评分详情
        ArrayList result_rat = movie_rat_repository.findBySubjectid(subjectID);

        Movie_Subject result = (Movie_Subject) result_list.get(0);
//        result.setSubject_comments(result_comments);
//        result.setSubject_reviews(result_reviews);
        result.setSubject_casts(result_casts);
        return result_list;
    }

    /**
     * 访问url请求影视的标签
     * @param subjectID
     */
    @Override
    public ArrayList getTags_url(String subjectID){
        if(logger.isInfoEnabled()){
            logger.info("【Movie_Details_ServiceImpl—setTags_url】请求成功！");
        }
        //定义返回对象
        ArrayList result_list = movie_tags_repository.findBySubjectid(subjectID);
        return result_list;
    }

    /**
     * 访问url请求影视的短评
     * @param subjectID
     */
    @Override
    public ArrayList getComments(String subjectID){
        if(logger.isInfoEnabled()){
            logger.info("【Movie_Details_ServiceImpl—getComments_url】请求成功！");
        }
        //定义返回对象
        ArrayList result_list = movie_comments_repository.findBySubjectid(subjectID);
        for (int i = 0; i < result_list.size(); i++) {
            Movie_Comments movie_comments = (Movie_Comments) result_list.get(i);
            ArrayList list_author = movie_author_repository.findByAuthorid(movie_comments.getComments_author_id());
            movie_comments.setComments_movie_author(list_author);
        }
        return result_list;
    }

    /**
     * 访问url请求影视的长评
     * @param subjectID
     */
    @Override
    public ArrayList getReviews(String subjectID){
        if(logger.isInfoEnabled()){
            logger.info("【Movie_Details_ServiceImpl—getReviews_url】请求成功！");
        }
        //定义返回对象
        ArrayList result_list = movie_reviews_repository.findBySubjectid(subjectID);
        // 获取长评
        for (int i = 0; i < result_list.size(); i++) {
            Movie_Reviews movie_reviews = (Movie_Reviews) result_list.get(i);
            ArrayList list_author = movie_author_repository.findByAuthorid(movie_reviews.getReviews_author_id());
            movie_reviews.setReviews_movie_author(list_author);
        }
        return result_list;
    }

    /**
     * 访问url请求影视的演职员
     * @param subjectID
     */
    @Override
    public ArrayList getCasts(String subjectID){
        if(logger.isInfoEnabled()){
            logger.info("【Movie_Details_ServiceImpl—getCasts】请求成功！");
        }
        //定义返回对象
        ArrayList result_list = movie_casts_repository.findBySubjectid(subjectID);
        return result_list;
    }

    /**
     * 访问url请求影视的评分
     * @param subjectID
     */
    @Override
    public ArrayList getRat(String subjectID){
        if(logger.isInfoEnabled()){
            logger.info("【Movie_Details_ServiceImpl—getRat】请求成功！");
        }
        //定义返回对象
        ArrayList result_list = movie_rat_repository.findBySubjectid(subjectID);
        return result_list;
    }

    /**
     * 访问url请求影视的剧照
     * @param subjectID
     */
    public ArrayList getPhotos(String subjectID){
        if(logger.isInfoEnabled()){
            logger.info("【Movie_Details_ServiceImpl—getPhotos_url】请求成功！");
        }
        //定义返回对象
        ArrayList result_list = movie_photos_repository.findBySubjectid(subjectID);
        return result_list;
    }

    /**
     * 访问url请求影视的播放资源
     * @param subjectID
     */
    public ArrayList getVideos(String subjectID){
        if(logger.isInfoEnabled()){
            logger.info("【Movie_Details_ServiceImpl—getVideos】请求成功！");
        }
        //定义返回对象
        ArrayList result_list = movie_video_repository.findBySubjectid(subjectID);
        return result_list;
    }

    /**
     * 访问url请求影视的预告片
     * @param subjectID
     */
    public ArrayList getPrevue(String subjectID){
        if(logger.isInfoEnabled()){
            logger.info("【Movie_Details_ServiceImpl—getPrevue】请求成功！");
        }
        //定义返回对象
        ArrayList result_list = movie_prevue_repository.findBySubjectid(subjectID);
        return result_list;
    }


}
