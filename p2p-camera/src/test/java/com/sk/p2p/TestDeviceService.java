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
        String post = bean.post("https://open.ys7.com/api/lapp/device/add", params);
        System.out.println(post);


    }
}
