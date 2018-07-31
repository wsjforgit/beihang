package com.sk.p2p;

import com.sk.base.utils.ApplicationContextUtil;
import com.sk.base.utils.HttpUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by WangYa on 2017/7/31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TestDeviceService {
    private static Logger logger = LoggerFactory.getLogger(TestDeviceService.class);

    @Test
    public void testSimpleRequest() {
//2.添加设备到萤石
        HttpUtils bean = ApplicationContextUtil.getBean(HttpUtils.class);
        Map<String, String> params = new HashMap<>();
        params.put("accessToken", "at.082swmc2495iij5sc166t9kwa96ut525-2rsittod5y-0uronzl-iqj9gwg94");
        params.put("deviceSerial", "117091953");
        params.put("validateCode", "XEQBOK");
        params.put("id", "5cc65d7add114c809369903b27be88c7");
        params.put("hospitalName", "wsjtest");
//        String post = bean.post("http://127.0.0.1:8080/api/v1/aaa/add", params);
//        String post = bean.post("http://127.0.0.1:8080/api/v1/aaa/updateDevice", params);
        String post = bean.post("http://127.0.0.1:8080/api/v1/aaa/selectAll", params);
//        String post = bean.post("http://47.95.238.222:8080/api/v1/aaa/selectAll", params);
        System.out.println(post);


    }
}
