package com.sk.p2p.camera.service;
import com.sk.base.service.BaseService;
import com.sk.p2p.camera.entity.Integralmall;

/**
 * Created by wsj on 2018/7/12.
 */
public interface IntegralmallService extends BaseService<Integralmall> {
    //根据id查询
    Integralmall findById(String id);



}
