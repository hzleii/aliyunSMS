package com.hzlei.registerlogin.util;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.stereotype.Component;

/**
 * @author hzlei
 * @Package com.hzlei.registerlogin
 * @date 2019/10/18 17:08
 * @Description: 手机短信验证码
 */
@Component
public class SMSVerificationCode {

    /**
     * 传入手机号和验证码
     * @param tel
     * @param code
     * @return 返回执行后的结果
     */
    public String getResult(String tel, String code) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FfZVDyx8F7G2ads2NAm", "rNBOh7jUJ7zpSyUucCjmy2YD3gRDoj");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        // 发送目标的手机号
        request.putQueryParameter("PhoneNumbers", tel);
        request.putQueryParameter("SignName", "南方姑娘");
        request.putQueryParameter("TemplateCode", "SMS_175537076");
        // 验证码
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code + "\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            return response.getData();
        } catch (ServerException e) {
            e.printStackTrace();
            return e.toString();
        } catch (ClientException e) {
            e.printStackTrace();
            return e.toString();
        }
    }

}
