package com.sk.p2p.camera.service;

import com.sk.base.service.BaseService;
import com.sk.p2p.camera.entity.CaseCenter;

public interface CaseCenterService extends BaseService<CaseCenter> {
    //根据id查询
    CaseCenter findById(String id);

}
