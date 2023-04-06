package com.liruilong.hros.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liruilong.hros.Exception.ValidateCodeException;
import com.liruilong.hros.model.RespBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description :

 * @Date: 2020/2/11 23:08
 */
@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        RespBean respBean = RespBean.error(e.getMessage());
           // 验证码自定义异常的处理
        if (e instanceof ValidateCodeException){
            respBean.setMsg(e.getMessage());
            //Security内置的异常处理
        }else if (e instanceof LockedException) {
            respBean.setMsg("账户被锁定请联系管理员!");
        } else if (e instanceof CredentialsExpiredException) {
            respBean.setMsg("密码过期请联系管理员!");
        } else if (e instanceof AccountExpiredException) {
            respBean.setMsg("账户过期请联系管理员!");
        } else if (e instanceof DisabledException) {
            respBean.setMsg("账户被禁用请联系管理员!");
        } else if (e instanceof BadCredentialsException) {
            respBean.setMsg("用户名密码输入错误,请重新输入!");
        }
        //将hr转化为Sting
        out.write(new ObjectMapper().writeValueAsString(respBean));
        out.flush();
        out.close();
    }
    @Bean
    public  MyAuthenticationFailureHandler getMyAuthenticationFailureHandler(){
        return new MyAuthenticationFailureHandler();
    }
}
