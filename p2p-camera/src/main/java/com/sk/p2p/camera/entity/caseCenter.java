package com.sk.p2p.camera.entity;

import com.sk.base.entity.BaseEntity;
import lombok.Data;

/**
 * Created by wsj on 2018/7/12.
 */
@Data
public class caseCenter extends BaseEntity {
    private String id;
    //案例名称
    private String caseName;
    //案例编号
    private String caseNum;
    //案例等级
    private String caseLevel;
    //药物名称
    private String drugName;
    //医药物编号
    private String drugNum;
    //持续时间
    private String sustainTime;
    //医院名称
    private String hospitalName;
    //医院地址
    private String hospitalUrl;
    //关联用户
    private String linkUser;
    //关联医院
    private String linkhospital;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getCaseNum() {
        return caseNum;
    }

    public void setCaseNum(String caseNum) {
        this.caseNum = caseNum;
    }

    public String getCaseLevel() {
        return caseLevel;
    }

    public void setCaseLevel(String caseLevel) {
        this.caseLevel = caseLevel;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugNum() {
        return drugNum;
    }

    public void setDrugNum(String drugNum) {
        this.drugNum = drugNum;
    }

    public String getSustainTime() {
        return sustainTime;
    }

    public void setSustainTime(String sustainTime) {
        this.sustainTime = sustainTime;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalUrl() {
        return hospitalUrl;
    }

    public void setHospitalUrl(String hospitalUrl) {
        this.hospitalUrl = hospitalUrl;
    }

    public String getLinkUser() {
        return linkUser;
    }

    public void setLinkUser(String linkUser) {
        this.linkUser = linkUser;
    }

    public String getLinkhospital() {
        return linkhospital;
    }

    public void setLinkhospital(String linkhospital) {
        this.linkhospital = linkhospital;
    }
}
