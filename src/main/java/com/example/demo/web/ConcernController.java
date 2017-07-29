package com.example.demo.web;

import com.example.demo.service.inner.ConcernService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhubuqing on 2017/7/29.
 */
@RestController
public class ConcernController {
    private static final Logger logger = LoggerFactory.getLogger(ConcernController.class);

    private ConcernService concernService;

    @Autowired
    public ConcernController(ConcernService concernService) {
        this.concernService = concernService;
    }
}
