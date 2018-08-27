package com.sk.p2p.camera.entity;

import com.sk.base.entity.BaseEntity;
import com.sk.base.utils.KeyGenerator;
import lombok.Data;

/**
 * Created by wsj on 2018/7/12.
 */
@Data
public class Medicalcenter extends BaseEntity {
    //信誉中心
    private String id;
    //医院名称
    private String hospitalName;
    //康复状态
    private String illnessStatus;
    //时间
    private String illnessTime ;
    //患者名称
    private String illnessMan;

    @Override
    public String getId() {
        if(id==null||"".equalsIgnoreCase(id)){
            id = KeyGenerator.getUUId();
        }else {
            id=id;
        }
        return id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getIllnessStatus() {
        return illnessStatus;
    }

    public void setIllnessStatus(String illnessStatus) {
        this.illnessStatus = illnessStatus;
    }

    public String getIllnessTime() {
        return illnessTime;
    }

    public void setIllnessTime(String illnessTime) {
        this.illnessTime = illnessTime;
    }

    public String getIllnessMan() {
        return illnessMan;
    }

    public void setIllnessMan(String illnessMan) {
        this.illnessMan = illnessMan;
    }
}
