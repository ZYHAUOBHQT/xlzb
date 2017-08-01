package com.example.demo.config;

/**
 * Created by zhubuqing on 2017/7/29.
 */
public interface ApiConf {
    /*----------------------------- 用户相关 -----------------------------*/
    String createOrUpdate = "liveRadio/zhiBo/createOrUpdate"; //创建/更新频道
    String inZhiBo = "liveRadio/zhiBo/inZhiBo"; //进入直播间
    String changeGzNum = "liveRadio/concern/changeGzNum"; //修改关注人数
    String homePage = "liveRadio/zhiBo/homePage"; //主页请求
    String login = "liveRadio/user/login"; //登录
    String getUserConcern = "liveRadio/concern/getUserConcern"; //获取某个人关注的频道
    String recommend = "liveRadio/zhiBo/recommend"; //推荐
    String outZhiBo = "liveRadio/zhiBo/outZhiBo"; //退出直播间
}
