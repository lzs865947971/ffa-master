package com.ffa.controller;

import com.ffa.po.RespBean;
import com.ffa.po.Role;
import com.ffa.po.UserInf;
import com.ffa.service.RoleService;
import com.ffa.service.UserInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
//@CrossOrigin可解决跨域
@RequestMapping("/sys/user")
public class UserInfController {

    @Autowired
    UserInfService userInfService;

    @Autowired
    RoleService roleService;

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
        Integer hrid = (Integer) info.get("hrid");
        if (userInfService.updateHrPasswd(oldpass, pass, hrid)) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @PostMapping("/")
    public RespBean addUserInf(@RequestBody UserInf userInf) {
        if (userInfService.addUserInf(userInf) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteUserInfById(@PathVariable Integer id) {
        if (userInfService.deleteUserInfById(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

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

}
