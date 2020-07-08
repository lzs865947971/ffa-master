package com.ffa.controller;

import com.ffa.po.RespBean;
import com.ffa.service.FirePersonInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin可解决跨域
@RequestMapping("/user")
public class FirePersonInfController {

    @Autowired
    FirePersonInfService firePersonInfService;


    @GetMapping("/")
    public List<FirePersonInf> getAllFirePersonInf(){
        return firePersonInfService.getAllFirePersonInf();
    }
    @PostMapping("/")
    public RespBean addFirePersonInf(@RequestBody FirePersonInf firePersonInf) {
        if (firePersonInfService.addFirePersonInf(firePersonInf) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteFirePersonInfById(@PathVariable Integer id) {
        if (firePersonInfService.deleteFirePersonInfById(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PutMapping("/")
    public RespBean updateFirePersonInfById(@RequestBody FirePersonInf firePersonInf) {
        if (firePersonInfService.updateFirePersonInfById(firePersonInf) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

}
