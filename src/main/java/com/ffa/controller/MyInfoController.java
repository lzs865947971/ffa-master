package com.ffa.controller;

import com.ffa.po.KeyUnit;
import com.ffa.po.RespBean;
import com.ffa.po.Role;
import com.ffa.po.UserInf;
import com.ffa.service.KeyUnitService;
import com.ffa.service.RoleService;
import com.ffa.service.UserInfService;
import com.ffa.utils.FastDFSUtils;
import com.ffa.utils.PinyinUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
public class MyInfoController {
    @Autowired
    UserInfService userInfService;

    @Autowired
    RoleService roleService;

    @Value("${ffa.nginx.host}")
    String nginxHost;

    //获取当前用户方法
    @GetMapping("/user/info")
    public UserInf getCurrentUser(Authentication authentication) {
        return ((UserInf) authentication.getPrincipal());
    }

    //修改用户信息方法
    @PutMapping("/user/info")
    public RespBean updateUserInfById(@RequestBody UserInf userInf) {
        if (userInfService.updateUserInfById(userInf) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    //修改密码方法
    @PutMapping("/user/pass")
    public RespBean updateUserPasswd(@RequestBody Map<String, Object> info) {
        String oldpass = (String) info.get("oldpass");
        String pass = (String) info.get("pass");
        Integer uid = (Integer) info.get("uid");
        //根据uid oldpass修改密码
        if (userInfService.updateHrPasswd(oldpass, pass, uid)) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    //修改用户头像方法
    @PostMapping("/user/userface")
    public RespBean updateUserface(MultipartFile file, Integer userId) {
        //获取fastdfs文件地址
        String upload = FastDFSUtils.upload(file);
        String url = nginxHost + upload;
        //更新头像路径
        if (userInfService.updateUserface(url, userId) == 1) {
            return RespBean.ok("更新成功!",url);
        }
        return RespBean.error("更新失败!");
    }

}
