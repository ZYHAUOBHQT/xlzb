package com.example.demo.repository;

import com.example.demo.po.Concern;
import com.example.demo.po.ZhiBo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhubuqing on 2017/7/29.
 */
@Repository
public interface ConcernRepository extends JpaRepository<Concern, Long> {
    Concern findByUserIdAndZhiBo(int userId, ZhiBo zhiBo);

    List<Concern> findByUserId(int userId);
}
