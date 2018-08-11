package com.sk.p2p.camera.service.impl;

import com.sk.base.service.impl.BaseServiceImpl;
import com.sk.base.utils.HttpUtils;
import com.sk.p2p.camera.entity.Cooperationcenter;
import com.sk.p2p.camera.entity.Cooperationcenter;
import com.sk.p2p.camera.mapper.CooperationcenterMapper;
import com.sk.p2p.camera.mapper.CooperationcenterMapper;
import com.sk.p2p.camera.service.CooperationcenterService;
import com.sk.p2p.camera.service.CooperationcenterService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CooperationcenterServiceImpl extends BaseServiceImpl<Cooperationcenter, CooperationcenterMapper> implements CooperationcenterService {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(HttpUtils.class);
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Autowired
    CooperationcenterMapper cooperationcenterMapper;

    @Autowired
    HttpUtils httpUtils;

    @Override
    public Cooperationcenter findById(String id) {
        Cooperationcenter backmessage = cooperationcenterMapper.selectById(id);
        return backmessage;
    }
}
