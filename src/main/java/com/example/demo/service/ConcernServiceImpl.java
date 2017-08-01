package com.example.demo.service;

import com.example.demo.po.Concern;
import com.example.demo.po.ZhiBo;
import com.example.demo.po.config.Api;
import com.example.demo.repository.ConcernRepository;
import com.example.demo.repository.ZhiBoRepository;
import com.example.demo.service.inner.ConcernService;
import com.example.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhubuqing on 2017/7/29.
 */
@Service
public class ConcernServiceImpl implements ConcernService {
    private Concern concern;

    private ZhiBo zhiBo;

    private ConcernRepository concernRepository;

    private ZhiBoRepository zhiBoRepository;

    @Autowired
    public ConcernServiceImpl(ConcernRepository concernRepository, ZhiBoRepository zhiBoRepository) {
        this.concernRepository = concernRepository;
        this.zhiBoRepository = zhiBoRepository;
    }

    /**
     * 修改关注人数
     *
     * @param userId
     * @param pdId
     * @return
     */
    @Override
    public ResponseEntity<?> changeGzNum(int userId, int pdId) {
        zhiBo = zhiBoRepository.findByPdId(pdId);
        concern = concernRepository.findByUserIdAndZhiBo(userId, zhiBo);
        Result<String> result = new Result<>();
        result.api(Api.SUCCESS);
        if (concern == null) {
            concern = new Concern();
            concern.setUserId(userId);
            concern.setZhiBo(zhiBo);
            concernRepository.saveAndFlush(concern);
            result.setData("CONCERN");
        } else {
            concernRepository.delete(concern);
            result.setData("CANCEL");
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 获取某个人关注的频道
     *
     * @param userId
     * @return
     */
    @Override
    public ResponseEntity<?> getUserConsern(int userId) {
        List<Concern> concerns = concernRepository.findByUserId(userId);
        List<ZhiBo> zhiBos = new ArrayList<>();
        for (int i = 0; i < concerns.size(); i++) {
            zhiBos.add(concerns.get(i).getZhiBo());
        }
        Result<List<ZhiBo>> result = new Result<>();
        result.api(Api.SUCCESS);
        result.setData(zhiBos);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
