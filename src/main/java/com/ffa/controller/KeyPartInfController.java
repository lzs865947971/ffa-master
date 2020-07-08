package com.ffa.controller;

import com.ffa.po.KeyPartInf;
import com.ffa.po.KeyUnit;
import com.ffa.service.KeyPartInfService;
import com.ffa.service.KeyUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin可解决跨域
@RequestMapping("/keypartinf")
public class KeyPartInfController {

    @Autowired
    KeyPartInfService keyPartInfService;


    @GetMapping("/")
    public List<KeyPartInf> getAllKeyPartInf(){
        return keyPartInfService.getAllKeyPartInf();
    }
    @PostMapping("/")
    public RespBean addKeyPartInf(@RequestBody KeyPartInf keyPartInf) {
        if (keyPartInfService.addKeyPartInf(keyPartInf) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteKeyPartInfById(@PathVariable Integer id) {
        if (keyPartInfService.deleteKeyPartInfById(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PutMapping("/")
    public RespBean updateKeyPartInfById(@RequestBody KeyPartInf keyPartInf) {
        if (keyPartInfService.updateKeyPartInfById(keyPartInf) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

}
