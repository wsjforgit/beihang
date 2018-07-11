package com.sk.p2p.camera.service.impl;

import com.sk.base.service.impl.BaseServiceImpl;
import com.sk.p2p.camera.entity.CircleDevice;
import com.sk.p2p.camera.mapper.CircleDeviceMapper;
import com.sk.p2p.camera.service.CircleDeviceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CircleDeviceServiceImpl extends BaseServiceImpl<CircleDevice, CircleDeviceMapper> implements CircleDeviceService {

}
