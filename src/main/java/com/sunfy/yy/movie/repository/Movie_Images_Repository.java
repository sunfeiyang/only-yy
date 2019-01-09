package com.sunfy.yy.movie.repository;

import com.sunfy.yy.movie.domain.Movie_Images;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * 海报数据库操作对象
 */
public interface Movie_Images_Repository extends JpaRepository<Movie_Images,Integer> {

    //根据subject_id过滤
    public ArrayList findBySubjectid(String subjectid);
}
