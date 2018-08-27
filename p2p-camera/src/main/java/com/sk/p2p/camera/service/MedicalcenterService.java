package com.sk.p2p.camera.service;

import com.sk.base.service.BaseService;
import com.sk.p2p.camera.entity.CaseCenter;
import com.sk.p2p.camera.entity.Medicalcenter;

public interface MedicalcenterService extends BaseService<Medicalcenter> {
    //根据id查询
    Medicalcenter findById(String id);

}
