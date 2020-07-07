package com.ffa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Service

    @GetMapping("/login")
    public RespBean login(){
        return RespBean.error("尚未登陆，请登录")；
    }


}
