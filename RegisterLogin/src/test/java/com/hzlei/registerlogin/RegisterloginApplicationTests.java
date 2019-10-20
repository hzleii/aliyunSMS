package com.hzlei.registerlogin;

import com.hzlei.registerlogin.util.SMSVerificationCode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RegisterloginApplicationTests {
    @Autowired
    private SMSVerificationCode smsVerificationCode;

    @Test
    void contextLoads() {
    }

}
