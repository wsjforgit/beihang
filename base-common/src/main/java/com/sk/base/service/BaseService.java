package com.sk.base.service;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by WangYajie on 2016/9/13.
 */
public interface BaseService<T> {
    /**
     * 根据id删除数据
     *
     * @param id id
     */
    void del(Serializable id);

    /**
     * 根据id数组删除数据
     *
     * @param ids id数组
     */
    void delByIds(Serializable[] ids);


    /**
     * 更新
     *
     * @param t
     */
    void update(T t);

    /**
     * 保存
     *
     * @param t
     */
    int save(T t);


    /**
     * 查询所有
     *
     * @return
     */
    List<T> findAll();

    /**
     * 根据id查询
     *
     * @param id id
     * @return
     */
    T findById(Serializable id);

    /**
     * 条件分页查询
     *
     * @param index
     * @param pageSize
     * @return
     */
    PageInfo<T> findByPage(int index, int pageSize);


    /**
     * 按条件查询
     *
     * @param index     开始
     * @param pageSize  每页多少条
     * @param condition 条件
     * @return
     */
    PageInfo<T> findByPageCondition(int index, int pageSize, Object condition);
}
