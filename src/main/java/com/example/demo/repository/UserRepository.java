package com.example.demo.repository;

import com.example.demo.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by zhubuqing on 2017/7/26.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(int userId);
}
