package com.ffa.controller;

import com.ffa.config.VerificationCode;
import com.ffa.po.RespBean;
import com.ffa.service.UserInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
public class LoginController {

    @Autowired
    UserInfService userInfService;

    @GetMapping("/login")
    public RespBean login(){
        return RespBean.error("尚未登陆，请登录");
    }

    @GetMapping("/verifyCode")
    public void verifyCode(HttpSession session, HttpServletResponse resp) throws IOException {
        VerificationCode code = new VerificationCode();
        BufferedImage image = code.getImage();
        String text = code.getText();
        session.setAttribute("verify_code", text);
        VerificationCode.output(image,resp.getOutputStream());
    }


}
