package com.sk.p2p.camera.controller;

import com.sk.base.commons.Result;
import com.sk.base.commons.ResultState;
import com.sk.base.controller.BaseController;
import com.sk.base.utils.JsonFormatOutUtil;
import com.sk.p2p.camera.entity.Medicalcenter;
import com.sk.p2p.camera.service.MedicalcenterService;
import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/medicalcenter")
public class MedicalcenterController extends BaseController {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private MedicalcenterService medicalcenterService;


    /**
     * 根据id查询数据
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public Result findById(@NotEmpty(message = "id不能为空") String id) {
        Medicalcenter backOne = medicalcenterService.findById(id);
        String backMessage ="";
        if(backOne!=null){
            backMessage = JsonFormatOutUtil.toJSONString(backOne);
//            try {
//                backMessage= URLEncoder.encode(backMessage, "utf-8");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
            logger.info(backMessage);
            return new Result(ResultState.SUCCESS, backMessage);
        }
        return new Result(ResultState.FAIL, "失败");
    }
    /**
     * 查询所有数据
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    public Result selectAll() {
        List<Medicalcenter> ListBack = medicalcenterService.findAll();
        if(ListBack!=null&&ListBack.size()>0){
            String backMessage = JsonFormatOutUtil.toJSONString(ListBack);
//            try {
//                backMessage= URLEncoder.encode(backMessage, "utf-8");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
            return new Result(ResultState.SUCCESS, backMessage);
        }
        return new Result(ResultState.SUCCESS, "失败");
    }


}
