package com.sk.p2p.camera.service;
import com.sk.base.service.BaseService;
import com.sk.p2p.camera.entity.Cooperationcenter;
import com.sk.p2p.camera.entity.Integralmall;

/**
 * Created by wsj on 2018/7/12.
 */
public interface CooperationcenterService extends BaseService<Cooperationcenter> {
    //根据id查询
    Cooperationcenter findById(String id);



}
