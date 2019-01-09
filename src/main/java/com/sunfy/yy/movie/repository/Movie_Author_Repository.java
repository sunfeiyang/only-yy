package com.sunfy.yy.movie.repository;

import com.sunfy.yy.movie.domain.Movie_Author;
import com.sunfy.yy.movie.domain.Movie_Year;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * 年份数据库操作对象
 */
public interface Movie_Author_Repository extends JpaRepository<Movie_Author,Integer> {

    //根据authorid进行过滤
    public ArrayList findByAuthorid(String authorid);
}
