package com.sk.p2p.camera.service;
import com.sk.base.service.BaseService;
import com.sk.p2p.camera.entity.HospitalEntity;

import java.util.List;

/**
 * Created by wsj on 2018/7/12.
 */
public interface HospitalEntityService extends BaseService<HospitalEntity> {
    HospitalEntity findById(String id);


}
