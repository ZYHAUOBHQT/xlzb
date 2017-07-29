package com.example.demo.service;

import com.example.demo.po.ZhiBo;
import com.example.demo.po.config.Api;
import com.example.demo.repository.ZhiBoRepository;
import com.example.demo.service.inner.ZhiBoService;
import com.example.demo.util.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Created by zhubuqing on 2017/7/26.
 */
@Service
public class ZhiBoServiceImpl implements ZhiBoService {
    private ZhiBo zhiBo;

    private ZhiBoRepository zhiBoRepository;

    /**
     * 创建/更新频道
     *
     * @param title
     * @param pdId
     * @return
     */
    @Override
    public ResponseEntity<?> createOrUpdate(String title, int pdId) {
        zhiBo = zhiBoRepository.getByPdId(pdId);
        Result<String> result = new Result<>();
        if (zhiBo == null) {
            zhiBo = new ZhiBo();
            zhiBo.setTitle(title);
            zhiBo.setPdId(pdId);
            ZhiBo z = zhiBoRepository.saveAndFlush(zhiBo);
            result.api(Api.SUCCESS);
            result.setData(z.getPic());
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            zhiBo.setTitle(title);
            ZhiBo z = zhiBoRepository.saveAndFlush(zhiBo);
            result.api(Api.SUCCESS);
            result.setData(z.getPic());
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }
}
