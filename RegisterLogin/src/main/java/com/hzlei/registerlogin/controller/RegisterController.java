package com.hzlei.registerlogin.controller;

import com.alibaba.fastjson.JSON;
import com.hzlei.registerlogin.bean.Staff;
import com.hzlei.registerlogin.service.RegisterService;
import com.hzlei.registerlogin.util.RandomVerificationCode;
import com.hzlei.registerlogin.util.SMSVerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author hzlei
 * @Package com.hzlei.registerlogin.controller
 * @date 2019/10/19 10:38
 * @Description: 员工controller
 */
@RestController
@RequestMapping("staff")
public class RegisterController {
    @Autowired
    private RandomVerificationCode randomVerificationCode;
    @Autowired
    private SMSVerificationCode smsVerificationCode;
    @Autowired
    private RegisterService registerService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    // add staff
    @RequestMapping("register")
    @ResponseBody
    public String register(Staff staff) {
        //System.out.println(staff);
        staff.setPassword(randomVerificationCode.getRandomString(6));
        return JSON.toJSONString(registerService.addStaff(staff));
    }

    // 发送验证码
    @RequestMapping("sendCode")
    @ResponseBody
    public String sendCode(String tel) {
        // 生成验证码
        String code = randomVerificationCode.getRandomString(6);
        // 添加验证码,60秒后失效
        stringRedisTemplate.opsForValue().set("code", code, 60, TimeUnit.SECONDS);
        String result = smsVerificationCode.getResult(tel, code);
        return JSON.toJSONString(result);
        //return JSON.toJSONString(code);
    }

    @RequestMapping("telExist")
    @ResponseBody
    public String telExist(String tel) {
        return JSON.toJSONString(registerService.telExist(tel));
    }

    // 验证验证码
    @RequestMapping("code")
    @ResponseBody
    public String code(String code) {
        // 根据key获取过期时间
        //System.out.println(stringRedisTemplate.getExpire("code"))
        String code1 = stringRedisTemplate.opsForValue().get("code");
        if (code1.toLowerCase().equals(code.toLowerCase()))
            return JSON.toJSONString("true");
        else return JSON.toJSONString("false");
    }

    // find all staff
    @RequestMapping("findAllStaff")
    @ResponseBody
    public String findAllStaff() {
        return JSON.toJSONString(registerService.findAllStaff());
    }

    // find all department
    @RequestMapping("findAllDepartment")
    @ResponseBody
    @Cacheable(value = "allDepartment")
    public String findAllDepartment() {
        return JSON.toJSONString(registerService.findAllDepartment());
    }

}
