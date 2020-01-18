package com.liruilong.hros.controller;

import com.liruilong.hros.model.RespBean;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description :
 * @Author: Liruilong
 * @Date: 2019/12/19 19:58
 */
@RestController
public class LoginController {
    @GetMapping("/login")
    public RespBean login(){
        return RespBean.error("尚未登录,请登录!");
    }
}
