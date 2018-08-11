package com.sk.p2p.camera.controller;

import com.sk.base.commons.Result;
import com.sk.base.commons.ResultState;
import com.sk.base.controller.BaseController;
import com.sk.base.utils.JsonFormatOutUtil;
import com.sk.p2p.camera.entity.Levelcenter;
import com.sk.p2p.camera.service.LevelcenterService;
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
@RequestMapping("/api/v1/levelcenter")
public class LevelcenterController extends BaseController {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private LevelcenterService levelcenterService;


    /**
     * 根据id查询数据
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    public Result findById(@NotEmpty(message = "id不能为空") String id) {
        Levelcenter backOne = levelcenterService.findById(id);
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
        List<Levelcenter> ListBack = levelcenterService.findAll();
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
