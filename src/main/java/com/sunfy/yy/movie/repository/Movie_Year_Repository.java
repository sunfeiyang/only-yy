package com.sunfy.yy.movie.repository;

import com.sunfy.yy.movie.domain.Movie_Year;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * 年份数据库操作对象
 */
public interface Movie_Year_Repository extends JpaRepository<Movie_Year,Integer> {

    //根据subject_id进行过滤
    public ArrayList findBySubjectid(String subjectid);

    //根据subject_id进行过滤
    public ArrayList findBySubjectidAndYearval(String subjectid,String yearval);
}
