package com.hzlei.registerlogin.util;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author hzlei
 * @Package com.hzlei.registerlogin
 * @date 2019/10/18 16:14
 * @Description: 随机生成验证码(包含数字,大写字母,小写字母)
 */
@Component
public class RandomVerificationCode {
    /**
     * 传入要生成验证码的长度,
     * @param length
     * @return 返回生成的验证码
     */
    public String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

}


