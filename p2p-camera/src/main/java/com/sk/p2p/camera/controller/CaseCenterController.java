package com.sk.p2p.camera.controller;

import com.sk.base.commons.Result;
import com.sk.base.commons.ResultState;
import com.sk.base.controller.BaseController;
import com.sk.base.utils.JsonFormatOutUtil;
import com.sk.p2p.camera.entity.CaseCenter;
import com.sk.p2p.camera.entity.Integralmall;
import com.sk.p2p.camera.service.CaseCenterService;
import com.sk.p2p.camera.service.IntegralmallService;
import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;


@RestController
@RequestMapping("/api/v1/caseCenter")
public class CaseCenterController extends BaseController {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private CaseCenterService caseCenterService;


    /**
     * 根据id查询数据
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public Result findById(@NotEmpty(message = "id不能为空") String id) {
        CaseCenter bakcOne = caseCenterService.findById(id);
        String backMessage ="";
        if(bakcOne!=null){
            backMessage = JsonFormatOutUtil.toJSONString(bakcOne);
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
        List<CaseCenter> ListBack = caseCenterService.findAll();
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
