package com.sk.p2p.camera.controller;

import com.sk.base.commons.Result;
import com.sk.base.commons.ResultState;
import com.sk.base.controller.BaseController;
import com.sk.p2p.camera.entity.HospitalEntity;
import com.sk.p2p.camera.service.DeviceService;
import com.sk.p2p.camera.service.HospitalEntityService;
import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/aaa")
public class HospitalEntityController extends BaseController {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private HospitalEntityService hospitalEntityService;


    /**
     * 添加设备
     *
     * @param circleId     社群id
     * @param deviceSerial 设备序列号
     * @param validateCode 设备验证码
     * @return
     */
    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    public Result findAll(@NotEmpty(message = "社群id不能为空") String circleId,
                      @NotEmpty(message = "设备序列号不能为空") String deviceSerial,
                      @NotEmpty(message = "设备验证码不能为空") String validateCode) {
        List<HospitalEntity> hospitalEntityList = hospitalEntityService.findAllHospital(circleId, deviceSerial, validateCode);
        System.out.println(hospitalEntityList+"");
        logger.info(hospitalEntityList+"");
        return new Result(ResultState.SUCCESS, "添加成功");
    }


}
