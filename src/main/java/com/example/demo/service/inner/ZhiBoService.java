package com.example.demo.service.inner;

import org.springframework.http.ResponseEntity;

/**
 * Created by zhubuqing on 2017/7/26.
 */
public interface ZhiBoService {
    ResponseEntity<?> createOrUpdate(String title, int pdId); //创建/更新频道
}
