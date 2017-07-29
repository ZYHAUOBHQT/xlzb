package com.example.demo.service;

import com.example.demo.po.Concern;
import com.example.demo.po.ZhiBo;
import com.example.demo.po.config.Api;
import com.example.demo.repository.ConcernRepository;
import com.example.demo.repository.ZhiBoRepository;
import com.example.demo.service.inner.ZhiBoService;
import com.example.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
        concern = concernRepository.findUserIdAndPdId(userId, pdId);
        zhiBo = zhiBoRepository.findByPdId(pdId);
        zhiBo.setZxNum(zhiBo.getZxNum() + 1);
        ZhiBo z = zhiBoRepository.saveAndFlush(zhiBo);
        Result<ZhiBo> result = new Result<>();
        result.api(Api.SUCCESS);
        if (concern == null)
            result.setMsg("1");
        else
            result.setMsg("0");
        result.setData(z);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
