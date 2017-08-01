package com.example.demo.util;

import com.example.demo.po.ZhiBo;

import java.util.List;

/**
 * Created by zhubuqing on 2017/7/31.
 */
public class Recommend {
    private List<ZhiBo> dayRecommend;
    private List<ZhiBo> weekRecommend;

    public Recommend() {
    }

    public Recommend(List<ZhiBo> dayRecommend, List<ZhiBo> weekRecommend) {
        this.dayRecommend = dayRecommend;
        this.weekRecommend = weekRecommend;
    }

    public List<ZhiBo> getDayRecommend() {
        return dayRecommend;
    }

    public void setDayRecommend(List<ZhiBo> dayRecommend) {
        this.dayRecommend = dayRecommend;
    }

    public List<ZhiBo> getWeekRecommend() {
        return weekRecommend;
    }

    public void setWeekRecommend(List<ZhiBo> weekRecommend) {
        this.weekRecommend = weekRecommend;
    }
}
