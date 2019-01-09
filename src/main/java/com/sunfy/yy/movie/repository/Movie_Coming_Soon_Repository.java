package com.sunfy.yy.movie.repository;

import com.sunfy.yy.movie.domain.Movie_Coming_Soon;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 即将热映数据库操作对象
 */
public interface Movie_Coming_Soon_Repository extends JpaRepository<Movie_Coming_Soon,Integer> {

    //根据Tid过滤
    public Movie_Coming_Soon findByTid(Integer tid);

    //根据subject_id进行过滤
    public Movie_Coming_Soon findBySubjectid(String subjectid);
}
