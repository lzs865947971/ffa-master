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
//@CrossOrigin可解决跨域
@RequestMapping("/org/basic")
public class FireOrgInfController {

    @Autowired
    FireOrgInfService fireOrgInfService;
    @Autowired
    KeyUnitService keyUnitService;

    @GetMapping("/")
    public List<FireOrgInf> getAllFireOrgInf(Authentication authentication, FireOrgInf fireOrgInf){
        UserInf userInf = (UserInf) authentication.getPrincipal();
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
        fireOrgInf.setFireOrgRegister(((UserInf) authentication.getPrincipal()).getName());
        if (fireOrgInfService.addFireOrgInf(fireOrgInf) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteFireOrgInfById(@PathVariable Integer id) {
        if (fireOrgInfService.deleteFireOrgInfById(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PutMapping("/")
    public RespBean updateFireOrgInfById(@RequestBody FireOrgInf fireOrgInf) {
        if (fireOrgInfService.updateFireOrgInfById(fireOrgInf) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }


}
