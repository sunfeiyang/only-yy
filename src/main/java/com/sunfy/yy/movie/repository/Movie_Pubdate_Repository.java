package com.sunfy.yy.movie.repository;

import com.sunfy.yy.movie.domain.Movie_Pubdate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * 上映日期数据库操作对象
 */
public interface Movie_Pubdate_Repository extends JpaRepository<Movie_Pubdate,Integer> {

    //根据subject_id进行过滤
    public ArrayList findBySubjectid(String subjectid);

    //根据subject_id进行过滤
    public ArrayList findBySubjectidAndPubdatedate(String subjectid,String pubdatedate);

}
