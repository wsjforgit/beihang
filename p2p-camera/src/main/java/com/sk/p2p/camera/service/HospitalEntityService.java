package com.sk.p2p.camera.service;
import com.sk.base.service.BaseService;
import com.sk.p2p.camera.entity.HospitalEntity;

import java.util.List;

/**
 * Created by wsj on 2018/7/12.
 */
public interface HospitalEntityService extends BaseService<HospitalEntity> {

    /**
     * 添加设备
     *  @param circleId     社群id
     * @param deviceSerial 设备序列号
     * @param validateCode 设备验证码
     */
    List<HospitalEntity> findAllHospital(String circleId, String deviceSerial, String validateCode);

}
