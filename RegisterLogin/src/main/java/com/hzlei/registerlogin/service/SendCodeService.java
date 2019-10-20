package com.hzlei.registerlogin.service;

/**
 * @author hzlei
 * @Package com.hzlei.registerlogin.service
 * @date 2019/10/19 09:04
 * @Description: 发送短信验证码接口
 */
public interface SendCodeService {
    // 传入手机号,返回发送result
    public String sendCode(String tel);
}
