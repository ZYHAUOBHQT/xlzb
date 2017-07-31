package com.example.demo.web;

import com.example.demo.config.ApiConf;
import com.example.demo.service.inner.ZhiBoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<?> createOrUpdate(@RequestParam int userId, @RequestParam String title, @RequestParam int pdId, HttpSession session) {
        return zhiBoService.createOrUpdate(userId, title, pdId);
    }

    /**
     * 进入直播间
     *
     * @param userId
     * @param pdId
     * @param session
     * @return
     */
    @PostMapping(value = ApiConf.inZhiBo, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> inZhiBo(@RequestParam int userId, @RequestParam int pdId, HttpSession session) {
        return zhiBoService.inZhiBo(userId, pdId);
    }

    /**
     * 主页请求
     *
     * @param session
     * @return
     */
    @PostMapping(value = ApiConf.homePage, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> homePage(HttpSession session) {
        return zhiBoService.homePage();
    }
}
