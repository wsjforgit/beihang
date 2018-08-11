package com.sk.p2p.camera.service.impl;

import com.sk.base.service.impl.BaseServiceImpl;
import com.sk.base.utils.HttpUtils;
import com.sk.p2p.camera.entity.HospitalEntity;
import com.sk.p2p.camera.entity.Integralmall;
import com.sk.p2p.camera.mapper.HospitalEntityMapper;
import com.sk.p2p.camera.mapper.IntegralmallMapper;
import com.sk.p2p.camera.service.HospitalEntityService;
import com.sk.p2p.camera.service.IntegralmallService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IntegralmallServiceImpl extends BaseServiceImpl<Integralmall, IntegralmallMapper> implements IntegralmallService {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(HttpUtils.class);
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Autowired
    IntegralmallMapper IntegralmallMapper;

    @Autowired
    HttpUtils httpUtils;

    @Override
    public Integralmall findById(String id) {
        Integralmall integralmall = IntegralmallMapper.selectById(id);
        return integralmall;
    }
}
