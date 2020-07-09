package com.ffa.controller;

import com.ffa.po.KeyPartInf;
import com.ffa.po.RespBean;
import com.ffa.service.KeyPartInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin可解决跨域
@RequestMapping("/unit/part")
public class KeyPartInfController {

    @Autowired
    KeyPartInfService keyPartInfService;

    @GetMapping("/")
    public List<KeyPartInf> getAllKeyPartInf(@RequestBody KeyPartInf keyPartInf){
        return keyPartInfService.getAllKeyPartInf(keyPartInf);
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
