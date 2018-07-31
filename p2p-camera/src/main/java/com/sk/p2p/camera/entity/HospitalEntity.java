package com.sk.p2p.camera.entity;

import com.sk.base.entity.BaseEntity;
import com.sk.base.utils.KeyGenerator;
import lombok.Data;

/**
 * Created by wsj on 2018/7/12.
 */
@Data
public class HospitalEntity extends BaseEntity {
    //医院表
    private String id;
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

    @Override
    public String getId() {
        if(id==null||"".equalsIgnoreCase(id)){
            id = KeyGenerator.getUUId();
        }else {
            id=id;
        }

        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalNum() {
        return hospitalNum;
    }

    public void setHospitalNum(String hospitalNum) {
        this.hospitalNum = hospitalNum;
    }

    public String getHospitalUrl() {
        return hospitalUrl;
    }

    public void setHospitalUrl(String hospitalUrl) {
        this.hospitalUrl = hospitalUrl;
    }

    public String getHospitalCall() {
        return hospitalCall;
    }

    public void setHospitalCall(String hospitalCall) {
        this.hospitalCall = hospitalCall;
    }

    public String getHospitalAbstract() {
        return hospitalAbstract;
    }

    public void setHospitalAbstract(String hospitalAbstract) {
        this.hospitalAbstract = hospitalAbstract;
    }

    public String getHospitalTeam() {
        return hospitalTeam;
    }

    public void setHospitalTeam(String hospitalTeam) {
        this.hospitalTeam = hospitalTeam;
    }

    public String getCrateTime() {
        return crateTime;
    }

    public void setCrateTime(String crateTime) {
        this.crateTime = crateTime;
    }

    public String getCrateMan() {
        return crateMan;
    }

    public void setCrateMan(String crateMan) {
        this.crateMan = crateMan;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateMan() {
        return updateMan;
    }

    public void setUpdateMan(String updateMan) {
        this.updateMan = updateMan;
    }

    public String getLinkUser() {
        return linkUser;
    }

    public void setLinkUser(String linkUser) {
        this.linkUser = linkUser;
    }

    public String getLinkFirm() {
        return linkFirm;
    }

    public void setLinkFirm(String linkFirm) {
        this.linkFirm = linkFirm;
    }
}
