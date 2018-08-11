package com.sk.p2p.camera.controller;

import com.sk.base.commons.Result;
import com.sk.base.commons.ResultState;
import com.sk.base.controller.BaseController;
import com.sk.base.utils.JsonFormatOutUtil;
import com.sk.p2p.camera.entity.Cooperationcenter;
import com.sk.p2p.camera.service.CooperationcenterService;
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
@RequestMapping("/api/v1/cooperationcenter")
public class CooperationcenterController extends BaseController {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private CooperationcenterService cooperationcenterService;


    /**
     * 根据id查询数据
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    public Result findById(@NotEmpty(message = "id不能为空") String id) {
        Cooperationcenter backOne = cooperationcenterService.findById(id);
        String backMessage ="";
        if(backOne!=null){
            backMessage = JsonFormatOutUtil.toJSONString(backOne);
            try {
                backMessage= URLEncoder.encode(backMessage, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
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
    @RequestMapping(value = "/selectAll", method = RequestMethod.POST)
    public Result selectAll() {
        List<Cooperationcenter> ListBack = cooperationcenterService.findAll();
        if(ListBack!=null&&ListBack.size()>0){
            String backMessage = JsonFormatOutUtil.toJSONString(ListBack);
            try {
                backMessage= URLEncoder.encode(backMessage, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return new Result(ResultState.SUCCESS, backMessage);
        }
        return new Result(ResultState.SUCCESS, "失败");
    }


}
