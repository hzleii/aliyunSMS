package com.hzlei.registerlogin.service.impl;

import com.hzlei.registerlogin.service.SendCodeService;
import com.hzlei.registerlogin.util.RandomVerificationCode;
import com.hzlei.registerlogin.util.SMSVerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hzlei
 * @Package com.hzlei.registerlogin.service.impl
 * @date 2019/10/19 09:06
 * @Description: 发送短信验证码实现类
 */
@Service
public class SendCodeServiceImpl implements SendCodeService {
    @Autowired
    private RandomVerificationCode randomVerificationCode;
    @Autowired
    private SMSVerificationCode smsVerificationCode;

    // 传入手机号,返回发送result
    @Override
    public String sendCode(String tel) {
        String code = randomVerificationCode.getRandomString(6);
        return smsVerificationCode.getResult(tel, code);
    }
}
