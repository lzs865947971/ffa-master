package com.ffa.controller;

import com.ffa.po.UserInf;
import com.ffa.service.UserInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    UserInfService userInfService;
    @GetMapping("/users")
    public List<UserInf> getAllHrs() {
        return userInfService.getAllUsersExceptCurrentHr();
    }
}
