package com.ffa.controller;

import com.ffa.po.FacilityInf;
import com.ffa.po.RespBean;
import com.ffa.service.FacilityInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin可解决跨域
@RequestMapping("/user")
public class FacilityInfController {

    @Autowired
    FacilityInfService facilityInfService;

    //获取全部用户
    @GetMapping("/")
    public List<FacilityInf> getAllFacilityInf(@RequestBody FacilityInf facilityInf){
        return facilityInfService.getAllFacilityInf(facilityInf);
    }
    @PostMapping("/")
    public RespBean addFacilityInf(@RequestBody FacilityInf facilityInf) {
        if (facilityInfService.addFacilityInf(facilityInf) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteFacilityInfById(@PathVariable Integer id) {
        if (facilityInfService.deleteFacilityInfById(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PutMapping("/")
    public RespBean updateFacilityInfById(@RequestBody FacilityInf facilityInf) {
        if (facilityInfService.updateFacilityInfById(facilityInf) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

}
