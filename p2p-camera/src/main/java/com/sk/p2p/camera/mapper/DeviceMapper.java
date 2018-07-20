package com.sk.p2p.camera.mapper;

import com.sk.base.mapper.BaseMapper;
import com.sk.p2p.camera.entity.Device;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DeviceMapper extends BaseMapper<Device> {
    /**
     * 查询全部数据
     *
     */
    List<Device> listDevice();

}
