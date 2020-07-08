package com.ffa.controller;

import com.ffa.po.KeyUnit;
import com.ffa.po.SecurityRisks;
import com.ffa.service.KeyUnitService;
import com.ffa.service.SecurityRisksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin可解决跨域
@RequestMapping("/keyunit")
public class KeyUnitController {

    @Autowired
    KeyUnitService keyUnitService;


    @GetMapping("/")
    public List<KeyUnit> getAllKeyUnit(){
        return keyUnitService.getAllKeyUnit();
    }
    @PostMapping("/")
    public RespBean addKeyUnit(@RequestBody KeyUnit keyUnit) {
        if (keyUnitService.addKeyUnit(keyUnit) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteKeyUnitById(@PathVariable Integer id) {
        if (keyUnitService.deleteKeyUnitById(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PutMapping("/")
    public RespBean updateKeyUnitById(@RequestBody KeyUnit keyUnit) {
        if (keyUnitService.updateKeyUnitById(keyUnit) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

}