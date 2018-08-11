package com.sk.p2p.camera.entity;

import com.sk.base.entity.BaseEntity;
import com.sk.base.utils.KeyGenerator;
import lombok.Data;

/**
 * Created by wsj on 2018/7/12.
 */
@Data
public class Levelcenter extends BaseEntity {
    //信誉中心
    private String id;
    //医院名称
    private String hospitalName;
    //购买药物订单
    private String drugOrder;
    //制药厂商
    private String drugName;
    //原材料订单
    private String rawOrder;
    //原材料供应商
    private String rowName;
    //时间
    private String orderTime;
    //信誉等级
    private String creditLevel;

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

    public String getDrugOrder() {
        return drugOrder;
    }

    public void setDrugOrder(String drugOrder) {
        this.drugOrder = drugOrder;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getRawOrder() {
        return rawOrder;
    }

    public void setRawOrder(String rawOrder) {
        this.rawOrder = rawOrder;
    }

    public String getRowName() {
        return rowName;
    }

    public void setRowName(String rowName) {
        this.rowName = rowName;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getCreditLevel() {
        return creditLevel;
    }

    public void setCreditLevel(String creditLevel) {
        this.creditLevel = creditLevel;
    }
}
