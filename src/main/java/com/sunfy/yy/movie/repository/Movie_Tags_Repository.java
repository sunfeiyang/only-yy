package com.sunfy.yy.movie.repository;

import com.sunfy.yy.movie.domain.Movie_Tags;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * 标签数据库操作对象
 */
public interface Movie_Tags_Repository extends JpaRepository<Movie_Tags,Integer> {

    //根据Tid过滤
    public ArrayList findBySubjectid(String subjectid);

    //根据subject_id进行过滤
    public ArrayList findBySubjectidAndTagsval(String subjectid,String tags_val);
}
