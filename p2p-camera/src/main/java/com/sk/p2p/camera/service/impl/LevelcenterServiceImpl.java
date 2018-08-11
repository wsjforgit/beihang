package com.sk.p2p.camera.service.impl;

import com.sk.base.service.impl.BaseServiceImpl;
import com.sk.base.utils.HttpUtils;
import com.sk.p2p.camera.entity.Levelcenter;
import com.sk.p2p.camera.mapper.LevelcenterMapper;
import com.sk.p2p.camera.service.LevelcenterService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LevelcenterServiceImpl extends BaseServiceImpl<Levelcenter, LevelcenterMapper> implements LevelcenterService {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(HttpUtils.class);
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Autowired
    LevelcenterMapper levelcenterMapper;

    @Autowired
    HttpUtils httpUtils;

    @Override
    public Levelcenter findById(String id) {
        Levelcenter backmessage = levelcenterMapper.selectById(id);
        return backmessage;
    }
}
