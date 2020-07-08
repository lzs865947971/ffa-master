package com.ffa.controller;

import com.ffa.po.SuperVisionInf;
import com.ffa.service.SuperVisionInfService;
import com.ffa.service.UserInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin可解决跨域
@RequestMapping("/supervisioninf")
public class SuperVisionInfController {

    @Autowired
    SuperVisionInfService superVisionInfService;


    @GetMapping("/")
    public List<SuperVisionInf> getAllSuperVisionInf(){
        return superVisionInfService.getAllSuperVisionInf();
    }
    @PostMapping("/")
    public RespBean addSuperVisionInf(@RequestBody SuperVisionInf superVisionInf) {
        if (superVisionInfService.addSuperVisionInf(superVisionInf) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteSuperVisionInfById(@PathVariable Integer id) {
        if (superVisionInfService.deleteSuperVisionInfById(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PutMapping("/")
    public RespBean updateUser_infById(@RequestBody SuperVisionInf superVisionInf) {
        if (superVisionInfService.updateSuperVisionInfById(superVisionInf) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

}
