package com.ffa.controller;

import com.ffa.po.FireOrgInf;
import com.ffa.po.KeyUnit;
import com.ffa.po.RespBean;
import com.ffa.po.UserInf;
import com.ffa.service.FireOrgInfService;
import com.ffa.service.KeyUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/org/basic")
/*
防火组织Controller类
 */
public class FireOrgInfController {

    @Autowired
    FireOrgInfService fireOrgInfService;
    @Autowired
    KeyUnitService keyUnitService;

    /*
    查询方法，根据用户单位id查询
     */
    @GetMapping("/")
    public List<FireOrgInf> getAllFireOrgInf(Authentication authentication, FireOrgInf fireOrgInf){
        //获取当前用户
        UserInf userInf = (UserInf) authentication.getPrincipal();
        //用户为火灾单位人员则根据单位id查询
        if(userInf.getUnitId() != null){
            fireOrgInf.setUnitId(userInf.getUnitId());
        }
        return fireOrgInfService.getAllFireOrgInf(fireOrgInf);
    }
    @PostMapping("/")
    public RespBean addFireOrgInf(Authentication authentication, @RequestBody FireOrgInf fireOrgInf) {
        KeyUnit keyUnit = new KeyUnit();
        keyUnit.setUnitId(fireOrgInf.getUnitId());
        fireOrgInf.setUnitName(keyUnitService.getAllKeyUnit(keyUnit).get(0).getUnitName());
        //添加火灾人员记录登记人
        fireOrgInf.setFireOrgRegister(((UserInf) authentication.getPrincipal()).getName());
        if (fireOrgInfService.addFireOrgInf(fireOrgInf) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteFireOrgInfById(@PathVariable Integer id) {
        fireOrgInfService.deleteFireOrgInfById(id);
        return RespBean.ok("删除成功！");

    }

    @PutMapping("/")
    public RespBean updateFireOrgInfById(@RequestBody FireOrgInf fireOrgInf) {
        if (fireOrgInfService.updateFireOrgInfById(fireOrgInf) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }


}
