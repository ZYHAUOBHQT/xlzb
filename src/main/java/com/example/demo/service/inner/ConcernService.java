package com.example.demo.service.inner;

import org.springframework.http.ResponseEntity;

/**
 * Created by zhubuqing on 2017/7/29.
 */
public interface ConcernService {
    ResponseEntity<?> changeGzNum(int userId, int pdId);
}
