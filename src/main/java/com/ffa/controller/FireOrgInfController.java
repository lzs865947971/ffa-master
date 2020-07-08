package com.ffa.controller;

import com.ffa.po.RespBean;
import com.ffa.service.FireOrgInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin可解决跨域
@RequestMapping("/user")
public class FireOrgInfController {

    @Autowired
    FireOrgInfService fireOrgInfService;


    @GetMapping("/")
    public List<FireOrgInf> getAllFireOrgInf(){
        return fireOrgInfService.getAllFireOrgInf();
    }
    @PostMapping("/")
    public RespBean addFireOrgInf(@RequestBody FireOrgInf fireOrgInf) {
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
