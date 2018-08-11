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
public class TestIntegralmallService {
    private static Logger logger = LoggerFactory.getLogger(TestIntegralmallService.class);

    @Test
    public void testSimpleRequest() {
        HttpUtils bean = ApplicationContextUtil.getBean(HttpUtils.class);
        Map<String, String> params = new HashMap<>();
        params.put("id", "1");
//        String post = bean.post("http://47.95.238.222:8080/api/v1/hospital/findById", params);
        String post = bean.post("http://127.0.0.1:8080/api/v1/integralmall/selectAll", params);
        logger.info(post);


    }
}
