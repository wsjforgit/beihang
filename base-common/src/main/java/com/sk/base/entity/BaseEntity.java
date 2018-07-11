package com.sk.base.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 基本抽象类
 */
@Data
public abstract class BaseEntity implements Serializable {
    // 主键uuid
    private String id;
    //创建时间
    private Date createDate;
    //修改时间
    private Date modifyDate;
    //    -1 删除 ,0 正常
    private int del = 0;
    //乐观锁
    private int version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public int getDel() {
        return del;
    }

    public void setDel(int del) {
        this.del = del;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
