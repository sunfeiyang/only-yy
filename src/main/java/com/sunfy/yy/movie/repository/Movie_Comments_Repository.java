package com.sunfy.yy.movie.repository;

import com.sunfy.yy.movie.domain.Movie_Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * 年份数据库操作对象
 */
public interface Movie_Comments_Repository extends JpaRepository<Movie_Comments,Integer> {

    //根据subject_id进行过滤
    public ArrayList findBySubjectid(String subjectid);

    //commentsid
    public ArrayList findByCommentsid(String commentsid);

    //commentsid&subject_id
    public ArrayList findByCommentsidAndSubjectid(String commentsid,String subjectid);
}
