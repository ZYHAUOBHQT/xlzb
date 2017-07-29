package com.example.demo.service;

import com.example.demo.po.Concern;
import com.example.demo.repository.ConcernRepository;
import com.example.demo.service.inner.ConcernService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Created by zhubuqing on 2017/7/29.
 */
@Service
public class ConcernServiceImpl implements ConcernService {
    private Concern concern;

    private ConcernRepository concernRepository;

    @Override
    public ResponseEntity<?> changeGzNum(int userId, int pdId) {
        return null;
    }
}
