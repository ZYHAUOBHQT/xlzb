package com.example.demo.repository;

import com.example.demo.po.ZhiBo;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhubuqing on 2017/7/26.
 */
@Repository
public interface ZhiBoRepository extends JpaRepository<ZhiBo, Long> {
    ZhiBo findByPdId(int pdId);

    List<ZhiBo> findByStatus(Pageable pageable, int status);

    List<ZhiBo> findByStatus(Pageable pageable, Sort sort);
}
