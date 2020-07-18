package com.ffa.controller;


import com.ffa.po.ChatMsg;
import com.ffa.po.UserInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class WsController {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    /*
    聊天消息发送方法
    */
    @MessageMapping("/ws/chat")
    public void handleMsg(Authentication authentication, ChatMsg chatMsg) {
        //获取当前用户
        UserInf userInf = (UserInf) authentication.getPrincipal();
        //添加消息数据
        chatMsg.setFrom(userInf.getUsername());
        chatMsg.setFromNickname(userInf.getName());
        chatMsg.setDate(new Date());
        simpMessagingTemplate.convertAndSendToUser(chatMsg.getTo(), "/queue/chat", chatMsg);
    }
}
