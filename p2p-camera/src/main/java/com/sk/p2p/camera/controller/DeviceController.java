package com.sk.p2p.camera.controller;

import com.alibaba.fastjson.JSONObject;
import com.sk.base.commons.Result;
import com.sk.base.commons.ResultState;
import com.sk.base.controller.BaseController;
import com.sk.base.utils.ApplicationContextUtil;
import com.sk.base.utils.HttpUtils;
import com.sk.base.utils.JsonFormatOutUtil;
import com.sk.p2p.camera.entity.Device;
import com.sk.p2p.camera.service.DeviceService;
import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/aaa")
public class DeviceController extends BaseController {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private DeviceService deviceService;

    /**
     * 添加设备
     *
     * @param circleId     社群id
     * @param deviceSerial 设备序列号
     * @param validateCode 设备验证码
     * @return
     */
    @RequestMapping(value = "/add")
    public Result add( String circleId,
                       String deviceSerial,
                       String validateCode) {
        logger.info("im  in add");
        Integer ii = deviceService.add(circleId, deviceSerial, validateCode);
        if(ii>0){
            return new Result(ResultState.SUCCESS, "添加成功");
        }else{
            return new Result(ResultState.FAIL, "添加失败");
        }
    }
    /**
     * 查询所有
     *
     * @return
     */
    @RequestMapping(value = "/selectAll")
    public Result selectAll() {
        logger.info("im  in selectAll");
        List<Device> ListDevice = deviceService.listDevice();
        if(ListDevice!=null&&ListDevice.size()>0){
            String backMessage = JsonFormatOutUtil.toJSONString(ListDevice);
            logger.info(backMessage);
            return new Result(ResultState.SUCCESS, backMessage);
        }
        return new Result(ResultState.SUCCESS, "失败");
    }
    /**
     * 根据id修改数据
     *
     * @return
     */
    @RequestMapping(value = "/updateDevice")
    public Result updateDevice(String id) {
        logger.info("im  in updateDevice");
        Integer ii = deviceService.updateDevice(id);
        if(ii>0){
            return new Result(ResultState.SUCCESS, "添加成功");
        }else{
            return new Result(ResultState.FAIL, "添加失败");
        }
    }


}
