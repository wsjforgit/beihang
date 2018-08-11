package com.sk.p2p.camera.service;

import com.sk.base.service.BaseService;
import com.sk.p2p.camera.entity.CaseCenter;
import com.sk.p2p.camera.entity.Levelcenter;

public interface LevelcenterService extends BaseService<Levelcenter> {
    //根据id查询
    Levelcenter findById(String id);

}
