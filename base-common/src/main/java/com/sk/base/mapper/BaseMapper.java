package com.sk.base.mapper;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface BaseMapper<T> {

    /**
     * 说明：根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     *
     * @param key 主键
     * @return T
     */
    T selectById(Object key);

    /**
     * 查询全部结果，
     *
     * @return all
     */
    List<T> selectAll();

    /**
     * 保存一个实体，null的属性也会保存，不会使用数据库默认值
     *
     * @param record
     * @return
     */
    int insert(T record);

    /**
     * 说明：根据主键更新实体全部字段，null值会被更新
     *
     * @param record
     * @return
     */
    int updateById(T record);

    /**
     * 条件查询,符串类型模糊匹配
     *
     * @param condition
     * @return
     */

    List<T> selectByCondition(Object condition);

    /**
     * 说明：批量插入，支持批量插入的数据库可以使用
     *
     * @param recordList
     * @return
     */
    int insertList(List<T> recordList);

    /**
     * 根据 id查询
     *
     * @param ids
     * @return
     */
    List<T> selectByIds( @Param("array")Serializable[] ids);

    /**
     * 说明：根据主键字段进行删除，
     * 方法参数必须包含完整的主键属性
     *
     * @param id
     * @return
     */
    int deleteById(Serializable id);
    /**
     * 根据id删除
     *
     * @param ids
     * @return
     */
    int deleteByIds(@Param("array") Serializable[] ids);

}
