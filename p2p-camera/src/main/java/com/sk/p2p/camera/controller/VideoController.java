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
@RequestMapping("/api/v1/video")
public class VideoController extends BaseController {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private LevelcenterService levelcenterService;

    /**
     * 查询所有数据
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/videoShow", method = RequestMethod.POST)
    public Result videoShow() {
        List<Levelcenter> ListBack = levelcenterService.findAll();
        if(ListBack!=null&&ListBack.size()>0){
            String backMessage = JsonFormatOutUtil.toJSONString(ListBack);
            return new Result(ResultState.SUCCESS, backMessage);
        }
        return new Result(ResultState.SUCCESS, "失败");
    }


}
