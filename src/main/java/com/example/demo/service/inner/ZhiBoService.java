package com.example.demo.service.inner;

import org.springframework.http.ResponseEntity;

/**
 * Created by zhubuqing on 2017/7/26.
 */
public interface ZhiBoService {
    ResponseEntity<?> createOrUpdate(int userId, String title, int pdId); //创建/更新频道

    ResponseEntity<?> inZhiBo(int userId, int pdId); //进入直播间

    ResponseEntity<?> homePage(); //主页请求

    ResponseEntity<?> recommend(); //推荐

    ResponseEntity<?> outZhiBo(int pdId); //退出直播间
}
