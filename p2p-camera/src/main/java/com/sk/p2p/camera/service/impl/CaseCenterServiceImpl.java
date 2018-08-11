package com.sk.p2p.camera.service.impl;

import com.sk.base.service.impl.BaseServiceImpl;
import com.sk.base.utils.HttpUtils;
import com.sk.p2p.camera.entity.CaseCenter;
import com.sk.p2p.camera.mapper.CaseCenterMapper;
import com.sk.p2p.camera.service.CaseCenterService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CaseCenterServiceImpl extends BaseServiceImpl<CaseCenter, CaseCenterMapper> implements CaseCenterService {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(HttpUtils.class);
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Autowired
    CaseCenterMapper caseCenterlMapper;

    @Autowired
    HttpUtils httpUtils;

    @Override
    public CaseCenter findById(String id) {
        CaseCenter caseCenter = caseCenterlMapper.selectById(id);
        return caseCenter;
    }
}
