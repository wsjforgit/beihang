package com.sk.base.utils;

import org.patchca.color.RandomColorFactory;
import org.patchca.filter.predefined.*;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.utils.encoder.EncoderHelper;
import org.patchca.word.WordFactory;

import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * 验证码工具类
 */
public class VerificationCode {
    public static String writeImg(OutputStream out, int length) throws IOException {
        ConfigurableCaptchaService cs = writeImg(length);
        String challenge = EncoderHelper.getChallangeAndWriteImage(cs, "png", out);
        out.flush();
        return challenge;
    }

    /**
     * 返回base64
     *
     * @param length 图片验证码长度
     * @return
     * @throws IOException
     */

    public static ConfigurableCaptchaService writeImg(int length) throws IOException {
        ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
//        RandomWordFactory wordFactory = new RandomWordFactory();
        WordFactory wordFactory = new WordFactory() {
            @Override
            public String getNextWord() {
                Random r = new Random();
                return r.nextInt(8999) + 1000 + "";
            }
        };
        cs.setWordFactory(wordFactory);
        RandomColorFactory randomColorFactory = new RandomColorFactory();
        randomColorFactory.setMax(new Color(255, 200, 255));
        randomColorFactory.setMin(new Color(1, 3, 254));
        cs.setColorFactory(randomColorFactory);
        switch (new Random().nextInt(5)) {
            case 0:
                cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));
                break;
            case 1:
                cs.setFilterFactory(new MarbleRippleFilterFactory());
                break;
            case 2:
                cs.setFilterFactory(new DoubleRippleFilterFactory());
                break;
            case 3:
                cs.setFilterFactory(new WobbleRippleFilterFactory());
                break;
            case 4:
                cs.setFilterFactory(new DiffuseRippleFilterFactory());
                break;
        }
        return cs;

    }

}
