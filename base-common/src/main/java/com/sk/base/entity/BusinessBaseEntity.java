package com.sk.base.entity;

import lombok.Data;

/**
 * 业务通用实体
 */
@Data
public abstract class BusinessBaseEntity extends BaseEntity {
    /**
     * 用户id
     */
    private String userId;

    /**
     * 数据审核人
     */
    private String auditUserId;

    /**
     * 数据所属域
     */
    private String domain;

}
