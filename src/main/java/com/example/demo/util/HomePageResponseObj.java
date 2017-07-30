package com.example.demo.util;

import com.example.demo.po.ZhiBo;

import java.util.List;

/**
 * Created by zhubuqing on 2017/7/30.
 */
public class HomePageResponseObj {
    List<ZhiBo> banner;
    List<ZhiBo> reBo;
    List<ZhiBo> reMen;

    public HomePageResponseObj() {
    }

    public HomePageResponseObj(List<ZhiBo> banner, List<ZhiBo> reBo, List<ZhiBo> reMen) {
        this.banner = banner;
        this.reBo = reBo;
        this.reMen = reMen;
    }

    public List<ZhiBo> getBanner() {
        return banner;
    }

    public void setBanner(List<ZhiBo> banner) {
        this.banner = banner;
    }

    public List<ZhiBo> getReBo() {
        return reBo;
    }

    public void setReBo(List<ZhiBo> reBo) {
        this.reBo = reBo;
    }

    public List<ZhiBo> getReMen() {
        return reMen;
    }

    public void setReMen(List<ZhiBo> reMen) {
        this.reMen = reMen;
    }
}
