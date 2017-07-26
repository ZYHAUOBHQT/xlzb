package com.example.demo.web;

import com.example.demo.service.inner.ZhiBoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhubuqing on 2017/7/26.
 */
@RestController
public class ZhiBoController {
    private static final Logger logger = LoggerFactory.getLogger(ZhiBoController.class);

    private ZhiBoService zhiBoService;

    @Autowired
    public ZhiBoController(ZhiBoService zhiBoService) {
        this.zhiBoService = zhiBoService;
    }
}
