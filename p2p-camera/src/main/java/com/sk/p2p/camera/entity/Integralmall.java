package com.sk.p2p.camera.entity;

import com.sk.base.entity.BaseEntity;
import com.sk.base.utils.KeyGenerator;
import lombok.Data;

/**
 * Created by wsj on 2018/7/12.
 */
@Data
public class Integralmall extends BaseEntity {
    //积分商城
    //id
    private String id;
    //用户名称
    private String userName;
    //签到记录
    private String signNum;
    //积分
    private String integral;
    //兑换记录
    private String exchangeRecord;
    //时间
    private String recordTime;
    //相关商城
    private String linkMall;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSignNum() {
        return signNum;
    }

    public void setSignNum(String signNum) {
        this.signNum = signNum;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public String getExchangeRecord() {
        return exchangeRecord;
    }

    public void setExchangeRecord(String exchangeRecord) {
        this.exchangeRecord = exchangeRecord;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public String getLinkMall() {
        return linkMall;
    }

    public void setLinkMall(String linkMall) {
        this.linkMall = linkMall;
    }
}
