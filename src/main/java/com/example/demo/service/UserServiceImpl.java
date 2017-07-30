package com.example.demo.service;

import com.example.demo.po.User;
import com.example.demo.po.config.Api;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.inner.UserService;
import com.example.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Created by zhubuqing on 2017/7/26.
 */
@Service
public class UserServiceImpl implements UserService {
    private User user;

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<?> login(int userId, String username, String password, String nickname) {
        user = userRepository.findByUserId(userId);
        if (user == null) {
            user = new User();
            user.setUserId(userId);
            user.setUsername(username);
            user.setPassword(password);
            user.setNickname(nickname);
            userRepository.saveAndFlush(user);
        } else {
            user.setUserId(userId);
            user.setUsername(username);
            user.setPassword(password);
            user.setNickname(nickname);
        }
        Result<String> result = new Result<>();
        result.api(Api.SUCCESS);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
