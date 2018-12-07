package com.sunfy.yy.culture.repository;

import com.sunfy.yy.culture.domain.Culture_Famous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 名人名言对应操作数据库的对象
 */
@Transactional
public interface Culture_Famous_Repository extends JpaRepository<Culture_Famous,Integer> {
    //自定义查询方法（通过姓名查询）
    //public List<Culture_Famous> findByFamous_name(String famous_name);

}
