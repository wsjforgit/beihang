package com.sk.p2p.camera.entity;

import com.sk.base.entity.BaseEntity;
import com.sk.base.utils.KeyGenerator;
import lombok.Data;
import org.apache.commons.codec.binary.Hex;

import java.util.Date;

@Data
public class Device extends BaseEntity {

    private String id;

    private String hospitalName;

    private String supplierName;

    private String herbsName;

    private String cooperationTime;

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

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getHerbsName() {
        return herbsName;
    }

    public void setHerbsName(String herbsName) {
        this.herbsName = herbsName;
    }

    public String getCooperationTime() {
        return cooperationTime;
    }

    public void setCooperationTime(String cooperationTime) {
        this.cooperationTime = cooperationTime;
    }
}
