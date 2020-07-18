package com.ffa.controller;

import com.ffa.utils.FastDFSUtils;
import com.ffa.utils.PinyinUtils;
import com.ffa.po.KeyUnit;
import com.ffa.po.RespBean;
import com.ffa.po.Role;
import com.ffa.po.UserInf;
import com.ffa.service.KeyUnitService;
import com.ffa.service.RoleService;
import com.ffa.service.UserInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
//@CrossOrigin可解决跨域
@RequestMapping("/sys/user")

/*
系统用户管理类
 */
public class UserInfController {

    @Autowired
    UserInfService userInfService;

    @Autowired
    RoleService roleService;

    @Autowired
    KeyUnitService keyUnitService;

    @Value("${ffa.nginx.host}")
    String nginxHost;

    //查询用户列表
    @GetMapping("/")
    public List<UserInf> getAllUserInf(String keywords){
        return userInfService.getAllUsers(keywords);
    }

    @GetMapping("/info")
    public UserInf getCurrentUser(Authentication authentication) {
        return ((UserInf) authentication.getPrincipal());
    }

    @PutMapping("/pass")
    public RespBean updateUserPasswd(@RequestBody Map<String, Object> info) {
        String oldpass = (String) info.get("oldpass");
        String pass = (String) info.get("pass");
        Integer uid = (Integer) info.get("uid");
        if (userInfService.updateHrPasswd(oldpass, pass, uid)) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    //添加用户方法，用户名默认为用户姓名全拼小写+用户编号，密码默认为123，并设置默认头像
    @PostMapping("/")
    public RespBean addUserInf(@RequestBody UserInf userInf) {
        KeyUnit keyUnit = new KeyUnit();
        keyUnit.setUnitId(userInf.getUnitId());
        try{
            userInf.setUnitName(keyUnitService.getAllKeyUnit(keyUnit).get(0).getUnitName());
        }
        catch (Exception e){
            System.out.println(e);
        }
        int userId = userInfService.getMaxUserId().intValue()+1;
        //用户姓名全拼小写+用户编号
        userInf.setUsername(PinyinUtils.toPinyin(userInf.getName()) + userId);
        //密码默认为123
        userInf.setPassword("$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm");
        //设置默认头像
        userInf.setUserface("http://192.168.43.123:8888/group1/M00/00/00/wKglhF8MuEyAYB1CAACwsYVT-AQ592.jpg");
        userInf.setEnabled(true);
        if (userInfService.addUserInf(userInf) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    //删除用户方法
    @DeleteMapping("/{id}")
    public RespBean deleteUserInfById(@PathVariable Integer id) {
        if (userInfService.deleteUserInfById(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
    //获取全部角色
    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PutMapping("/role")
    public RespBean updateHrRole(Integer uid, Integer[] rids) {
        if (userInfService.updateHrRole(uid, rids)) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @PutMapping("/")
    public RespBean updateUserInfById(@RequestBody UserInf userInf) {
        if (userInfService.updateUserInfById(userInf) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
    @PostMapping("/userface")
    public RespBean updateUserface(MultipartFile file, Integer userId) {
        String upload = FastDFSUtils.upload(file);
        String url = nginxHost + upload;
        if (userInfService.updateUserface(url, userId) == 1) {
            return RespBean.ok("更新成功!",url);
        }
        return RespBean.error("更新失败!");
    }


}
