package com.example.demo.service;

import com.example.demo.po.Concern;
import com.example.demo.po.config.Api;
import com.example.demo.repository.ConcernRepository;
import com.example.demo.service.inner.ConcernService;
import com.example.demo.util.Result;
import org.springframework.http.HttpStatus;
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
        concern = new Concern();
        concern.setPdId(pdId);
        concern.setUserId(userId);
        concernRepository.saveAndFlush(concern);
        Result<String> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData("SUCCESS");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
