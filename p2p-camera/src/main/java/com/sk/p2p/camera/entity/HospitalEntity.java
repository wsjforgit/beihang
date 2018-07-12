package com.sk.p2p.camera.entity;

import com.sk.base.entity.BaseEntity;
import lombok.Data;

/**
 * Created by wsj on 2018/7/12.
 */
@Data
public class HospitalEntity extends BaseEntity {
    //医院表
    private Integer id;
    //医院名称
    private String hospitalName;
    //医院编号
    private String hospitalNum;
    //医院地址
    private String hospitalUrl;
    //医院联系方式
    private String hospitalCall;
    //医院简介
    private String hospitalAbstract;
    //医院团队简介
    private String hospitalTeam;
    //创建时间
    private String crateTime;
    //创建人
    private String crateMan;
    //修改时间
    private String updateTime;
    //修改人
    private String updateMan;
    //关联用户
    private String linkUser;
    //关联企业
    private String linkFirm;
}
