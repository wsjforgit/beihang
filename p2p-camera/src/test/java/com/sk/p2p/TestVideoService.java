package com.sk.p2p;

import com.sk.base.utils.ApplicationContextUtil;
import com.sk.base.utils.HttpUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by WangYa on 2017/7/31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TestVideoService {
    private static Logger logger = LoggerFactory.getLogger(TestVideoService.class);

    @Test
    public void testSimpleRequest() {
        HttpUtils bean = ApplicationContextUtil.getBean(HttpUtils.class);
        Map<String, String> params = new HashMap<>();
        params.put("id", "1");
        String post = bean.post("http://127.0.0.1:8080/api/v1/video/videoShow", params);
        logger.info(post);


    }
}
