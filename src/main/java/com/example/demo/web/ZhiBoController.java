package com.example.demo.web;

import com.example.demo.config.ApiConf;
import com.example.demo.service.inner.ZhiBoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

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

    /**
     * 创建/更新频道
     *
     * @param title
     * @param pdId
     * @param session
     * @return
     */
    @PostMapping(value = ApiConf.createOrUpdate, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> createOrUpdate(@RequestParam String title, @RequestParam int pdId, HttpSession session) {
        return zhiBoService.createOrUpdate(title, pdId);
    }
}
