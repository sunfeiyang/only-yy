package com.sunfy.yy.movie.repository;

import com.sunfy.yy.movie.domain.Movie_Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * 年份数据库操作对象
 */
public interface Movie_Reviews_Repository extends JpaRepository<Movie_Reviews,Integer> {

    //根据subject_id进行过滤
    public ArrayList findBySubjectid(String subjectid);

    //reviewsid
    public ArrayList findByReviewsid(String reviewsid);

    //reviewsid&subject_id
    public ArrayList findByReviewsidAndSubjectid(String reviewsid, String subjectid);
}
