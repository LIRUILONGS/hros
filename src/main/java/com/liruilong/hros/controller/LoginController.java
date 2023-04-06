package com.liruilong.hros.controller;

import com.liruilong.hros.model.RespBean;
import com.wf.captcha.ArithmeticCaptcha;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @Description :

 * @Date: 2019/12/19 19:58
 */
@RestController
public class LoginController {

    private static Logger Loggerlogger = Logger.getLogger("LoginController");

    @GetMapping("/login")
    public RespBean login(){
        return RespBean.error("尚未登录,请登录!");
    }
    @GetMapping(value = "/auth/code")
    public Map getCode(HttpServletRequest request){
        // 算术类型 https://gitee.com/whvse/EasyCaptcha
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(111, 36);
        // 几位数运算，默认是两位
        captcha.setLen(2);
        // 获取运算的结果
        String result = captcha.text();
        Loggerlogger.warning("生成的验证码："+result);
        result = result.equals("0.0") ? "0":result;

        // 保存
        // 验证码信息
        Map<String,Object> imgResult = new HashMap<String,Object>(2){{
            put("img", captcha.toBase64());

        }};
        request.getSession().setAttribute("yanzhengma",result+"");
        Loggerlogger.warning("校验码为："+result);
        return imgResult;
    }
}
