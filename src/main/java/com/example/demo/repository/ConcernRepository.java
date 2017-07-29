package com.example.demo.repository;

import com.example.demo.po.Concern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by zhubuqing on 2017/7/29.
 */
@Repository
public interface ConcernRepository extends JpaRepository<Concern, Long> {
    Concern findUserIdAndPdId(int userId, int pdId);
}
