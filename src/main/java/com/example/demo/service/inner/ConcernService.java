package com.example.demo.service.inner;

import org.springframework.http.ResponseEntity;

/**
 * Created by zhubuqing on 2017/7/29.
 */
public interface ConcernService {
    ResponseEntity<?> changeGzNum(int userId, int pdId); //修改关注人数

    ResponseEntity<?> getUserConsern(int userId); //获取某个人关注的频道
}
