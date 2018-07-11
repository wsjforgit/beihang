package com.sk.base.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sk.base.entity.BaseEntity;
import com.sk.base.mapper.BaseMapper;
import com.sk.base.service.BaseService;
import com.sk.base.utils.KeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 基础server 提供增删改查
 *
 * @param <E>实体类
 * @param <T>    dao层对象
 */
public abstract class BaseServiceImpl<E extends BaseEntity, T extends BaseMapper<E>> implements BaseService<E> {


    @Autowired
    public T mapper;

    /**
     * 根据id删除对象
     *
     * @param id id
     */
    @Override
    public void del(Serializable id) {
        mapper.deleteById(id);
    }

    /**
     * 根据id数组,删除对象
     *
     * @param ids id数组
     */
    @Override
    public void delByIds(Serializable[] ids) {
        mapper.deleteByIds(ids);
    }

    /**
     * 更新
     *
     * @param e
     */
    @Override
    public void update(E e) {
        e.setModifyDate(new Date());
        mapper.updateById(e);
    }

    /**
     * 保存
     *
     * @param e
     */
    @Override
    public int save(E e) {
        e.setCreateDate(new Date());
        e.setModifyDate(new Date());
        e.setId(KeyGenerator.getUUId());
        return mapper.insert(e);
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<E> findAll() {
        return mapper.selectAll();
    }

    /**
     * 按ID查询
     *
     * @param id id
     * @return
     */
    @Override
    public E findById(Serializable id) {
        return mapper.selectById(id);
    }

    @Override
    public PageInfo<E> findByPage(int index, int pageSize) {
        PageHelper.startPage(index, pageSize);
        List<E> list = mapper.selectAll();
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<E> findByPageCondition(int index, int pageSize, Object condition) {
        PageHelper.startPage(index, pageSize);
        List<E> list = mapper.selectByCondition(condition);
        return new PageInfo<>(list);
    }


}
