package com.sk.base.service;

import java.util.Map;

/**
 * Created by Yuanbo on 2016/11/4.
 */
public interface QueryBuilder {
    /**
     * @param parameter 参数
     * @return
     */
    String buildQuery(Map<String, Object> parameter);
}
