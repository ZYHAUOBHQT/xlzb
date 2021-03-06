package com.example.demo.service;

import com.example.demo.po.Concern;
import com.example.demo.po.ZhiBo;
import com.example.demo.po.config.Api;
import com.example.demo.repository.ConcernRepository;
import com.example.demo.repository.ZhiBoRepository;
import com.example.demo.service.inner.ZhiBoService;
import com.example.demo.util.HomePageResponseObj;
import com.example.demo.util.Recommend;
import com.example.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhubuqing on 2017/7/26.
 */
@Service
public class ZhiBoServiceImpl implements ZhiBoService {
    private ZhiBo zhiBo;

    private Concern concern;

    private ZhiBoRepository zhiBoRepository;

    private ConcernRepository concernRepository;

    @Autowired
    public ZhiBoServiceImpl(ZhiBoRepository zhiBoRepository, ConcernRepository concernRepository) {
        this.zhiBoRepository = zhiBoRepository;
        this.concernRepository = concernRepository;
    }

    /**
     * 创建/更新频道
     *
     * @param title
     * @param pdId
     * @return
     */
    @Override
    public ResponseEntity<?> createOrUpdate(int userId, String title, int pdId) {
        zhiBo = zhiBoRepository.findByPdId(pdId);
        Result<String> result = new Result<>();
        if (zhiBo == null) {
            zhiBo = new ZhiBo();
            zhiBo.setTitle(title);
            zhiBo.setPdId(pdId);
            zhiBo.setUserId(userId);
            zhiBo.setStatus(1);
            ZhiBo z = zhiBoRepository.saveAndFlush(zhiBo);
            result.api(Api.SUCCESS);
            result.setData(z.getPic());
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            zhiBo.setTitle(title);
            zhiBo.setStatus(1);
            ZhiBo z = zhiBoRepository.saveAndFlush(zhiBo);
            result.api(Api.SUCCESS);
            result.setData(z.getPic());
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    /**
     * 进入直播间
     *
     * @param userId
     * @param pdId
     * @return
     */
    @Override
    public ResponseEntity<?> inZhiBo(int userId, int pdId) {
        Result<ZhiBo> result = new Result<>();
        result.api(Api.SUCCESS);
        zhiBo = zhiBoRepository.findByPdId(pdId);
        if (zhiBo.getUserId() == userId) {
            result.setMsg("2");
        } else {
            concern = concernRepository.findByUserIdAndZhiBo(userId, zhiBo);
            zhiBo.setZxNum(zhiBo.getZxNum() + 1);
            ZhiBo z = zhiBoRepository.saveAndFlush(zhiBo);

            if (concern == null)
                result.setMsg("0");
            else
                result.setMsg("1");
            result.setData(z);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 主页请求
     *
     * @return
     */
    @Override
    public ResponseEntity<?> homePage() {
        int status = 1;
        Sort zxNum = new Sort(Sort.Direction.DESC, "zxNum");
        PageRequest bannerPageRequest = new PageRequest(0, 3, zxNum);
        List<ZhiBo> banner = zhiBoRepository.findByStatus(bannerPageRequest, status);

        PageRequest reBoPageRequest = new PageRequest(0, 3, zxNum);
        List<ZhiBo> reBo = zhiBoRepository.findAll(reBoPageRequest).getContent();

        Sort gzNum = new Sort(Sort.Direction.DESC, "gzNum");
        PageRequest reMenPageRequest = new PageRequest(0, 20, gzNum);
        List<ZhiBo> reMen = zhiBoRepository.findAll(reMenPageRequest).getContent();

        HomePageResponseObj homePageResponseObj = new HomePageResponseObj(banner, reBo, reMen);
        Result<HomePageResponseObj> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData(homePageResponseObj);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 推荐
     *
     * @return
     */
    @Override
    public ResponseEntity<?> recommend() {
        Sort zxNum = new Sort(Sort.Direction.DESC, "zxNum");
        PageRequest dayPageRequest = new PageRequest(0, 4, zxNum);
        List<ZhiBo> dayRecommends = zhiBoRepository.findAll(dayPageRequest).getContent();

        Sort gzNum = new Sort(Sort.Direction.DESC, "gzNum");
        PageRequest weekPageRequest = new PageRequest(0, 4, gzNum);
        List<ZhiBo> weekRecommends = zhiBoRepository.findAll(weekPageRequest).getContent();

        Recommend recommend = new Recommend(dayRecommends, weekRecommends);

        Result<Recommend> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData(recommend);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 退出直播间
     *
     * @param pdId
     * @return
     */
    @Override
    public ResponseEntity<?> outZhiBo(int pdId) {
        zhiBo = zhiBoRepository.findByPdId(pdId);
        zhiBo.setZxNum(zhiBo.getZxNum() - 1);
        ZhiBo z = zhiBoRepository.saveAndFlush(zhiBo);
        Result<ZhiBo> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData(z);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
