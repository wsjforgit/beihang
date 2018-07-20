package com.sk.p2p.camera.service;

import com.alibaba.fastjson.JSONObject;
import com.sk.base.service.BaseService;
import com.sk.p2p.camera.entity.Device;

import java.util.List;
import java.util.Map;

public interface DeviceService extends BaseService<Device> {

    /**
     * 添加设备
     *
     * @param circleId     社群id
     * @param deviceSerial 设备序列号
     * @param validateCode 设备验证码
     */
    Integer add(String circleId, String deviceSerial, String validateCode);
    /**
     * 查询全部数据
     *
     */
    List<Device> listDevice();

    /**
     * 根据id修改数据
     *
     */
    Integer updateDevice(String id);

}
