package com.sk.p2p.camera.service.impl;

import com.sk.base.service.impl.BaseServiceImpl;
import com.sk.base.utils.HttpUtils;
import com.sk.p2p.camera.entity.CaseCenter;
import com.sk.p2p.camera.entity.Medicalcenter;
import com.sk.p2p.camera.mapper.CaseCenterMapper;
import com.sk.p2p.camera.mapper.MedicalcenterMapper;
import com.sk.p2p.camera.service.CaseCenterService;
import com.sk.p2p.camera.service.MedicalcenterService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MedicalcenterServiceImpl extends BaseServiceImpl<Medicalcenter, MedicalcenterMapper> implements MedicalcenterService {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(HttpUtils.class);
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Autowired
    MedicalcenterMapper caseCenterlMapper;

    @Autowired
    HttpUtils httpUtils;

    @Override
    public Medicalcenter findById(String id) {
        return null;
    }
}
