package com.example.demo.web;

import com.example.demo.config.ApiConf;
import com.example.demo.service.inner.ConcernService;
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

    /**
     * 修改关注人数
     *
     * @param userId
     * @param pdId
     * @param session
     * @return
     */
    @PostMapping(value = ApiConf.changeGzNum, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> changeGzNum(@RequestParam int userId, @RequestParam int pdId, HttpSession session) {
        return concernService.changeGzNum(userId, pdId);
    }

    /**
     * 获取某个人关注的频道
     *
     * @param userId
     * @param session
     * @return
     */
    @PostMapping(value = ApiConf.getUserConcern, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getZhiBoConsern(@RequestParam int userId, HttpSession session) {
        return concernService.getUserConsern(userId);
    }
}
