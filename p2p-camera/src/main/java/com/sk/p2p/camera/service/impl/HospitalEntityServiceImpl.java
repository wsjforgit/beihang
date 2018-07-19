package com.sk.p2p.camera.service.impl;

import com.sk.base.service.impl.BaseServiceImpl;
import com.sk.base.utils.HttpUtils;
import com.sk.p2p.camera.entity.HospitalEntity;
import com.sk.p2p.camera.mapper.CircleDeviceMapper;
import com.sk.p2p.camera.mapper.HospitalEntityMapper;
import com.sk.p2p.camera.service.CircleDeviceService;
import com.sk.p2p.camera.service.HospitalEntityService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HospitalEntityServiceImpl extends BaseServiceImpl<HospitalEntity, HospitalEntityMapper> implements HospitalEntityService {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(HttpUtils.class);
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Autowired
    HospitalEntityMapper HospitalEntityMapper;

    @Autowired
    HttpUtils httpUtils;

    //添加设备
    @Override
    public List<HospitalEntity> findAllHospital(String circleId, String deviceSerial, String validateCode) {
        List<HospitalEntity> hospitalEntityList = HospitalEntityMapper.selectAll();

        return hospitalEntityList;
//  throw new BusinessException("设备已被占用", "5001");
    }

}
