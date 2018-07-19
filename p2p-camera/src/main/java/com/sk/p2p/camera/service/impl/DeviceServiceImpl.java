package com.sk.p2p.camera.service.impl;

import com.sk.base.service.impl.BaseServiceImpl;
import com.sk.base.utils.HttpUtils;
import com.sk.p2p.camera.entity.Device;
import com.sk.p2p.camera.mapper.CircleDeviceMapper;
import com.sk.p2p.camera.mapper.DeviceMapper;
import com.sk.p2p.camera.service.CircleDeviceService;
import com.sk.p2p.camera.service.DeviceService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class DeviceServiceImpl extends BaseServiceImpl<Device, DeviceMapper> implements DeviceService {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(HttpUtils.class);
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Autowired
    CircleDeviceMapper circleDeviceMapper;

    @Autowired
    CircleDeviceService circleDeviceService;
    @Autowired
    HttpUtils httpUtils;
    @Autowired
    DeviceMapper DeviceMapper;

    //添加设备
    @Override
    @Caching(
            evict = {
                    @CacheEvict(value = "p2p:cameraList", allEntries = true),
            }
    )
    public void add(String circleId, String deviceSerial, String validateCode) {
        System.out.println("im in=======");
        Device device = new Device();
        device.setCreateDate(new Date());
        device.setHerbsName(circleId);
        device.setHospitalName(deviceSerial);
        device.setSupplierName(validateCode);
        DeviceMapper.insert(device);
//  throw new BusinessException("设备已被占用", "5001");
    }


}
