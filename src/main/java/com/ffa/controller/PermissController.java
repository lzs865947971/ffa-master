package com.ffa.controller;


import com.ffa.po.Menu;
import com.ffa.po.RespBean;
import com.ffa.po.Role;
import com.ffa.service.MenuService;
import com.ffa.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
权限组管理
 */
@RestController
@RequestMapping("/sys/permission")
public class PermissController {
    @Autowired
    RoleService roleService;
    @Autowired
    MenuService menuService;
    @GetMapping("/")
    //获取全部角色
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }
    //获取全部菜单
    @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    //根据角色id查询菜单列表
    @GetMapping("/mids/{rid}")
    public List<Integer> getMidsByRid(@PathVariable Integer rid) {
        return menuService.getMidsByRid(rid);
    }

    //更新角色权限
    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        if (menuService.updateMenuRole(rid, mids)) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    //添加角色
    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role) {
        if (roleService.addRole(role) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    //删除角色
    @DeleteMapping("/role/{rid}")
    public RespBean deleteRoleById(@PathVariable Integer rid) {
        if (roleService.deleteRoleById(rid) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
}
