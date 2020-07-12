package com.ffa.controller;

import com.ffa.po.FixRecordInf;
import com.ffa.po.RespBean;
import com.ffa.service.FixRecordInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin可解决跨域
@RequestMapping("/facility/fix")
public class FixRecordInfController {

    @Autowired
    FixRecordInfService fixRecordInfService;


    @GetMapping("/")
    public List<FixRecordInf> getAllFixRecordInf(FixRecordInf fixRecordInf){
        return fixRecordInfService.getAllFixRecordInf(fixRecordInf);
    }
    @PostMapping("/")
    public RespBean addUser_inf(@RequestBody FixRecordInf fixRecordInf) {
        if (fixRecordInfService.addFixRecordInf(fixRecordInf) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteUser_infById(@PathVariable Integer id) {
        if (fixRecordInfService.deleteFixRecordInfById(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PutMapping("/")
    public RespBean updateUser_infById(@RequestBody FixRecordInf fixRecordInf) {
        if (fixRecordInfService.updateFixRecordInfById(fixRecordInf) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

}
