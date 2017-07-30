package com.example.demo.service.inner;

import org.springframework.http.ResponseEntity;

/**
 * Created by zhubuqing on 2017/7/26.
 */
public interface UserService {
    ResponseEntity<?> login(int userId, String username, String password, String nickname);
}
