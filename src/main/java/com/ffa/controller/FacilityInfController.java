package com.ffa.controller;

import com.ffa.po.FacilityInf;
import com.ffa.po.RespBean;
import com.ffa.po.RespPageBean;
import com.ffa.service.FacilityInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin可解决跨域
@RequestMapping("/facility/basic")
public class FacilityInfController {

    @Autowired
    FacilityInfService facilityInfService;


//    @GetMapping("/")
//    public RespPageBean getAllFacilityInf(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, FacilityInf facility){
//        return facilityInfService.getEmployeeByPage(page, size, facility);
//    }
    @GetMapping("/")
    public List<FacilityInf> getAllFacilityInf(FacilityInf facility){
        return  facilityInfService.getAllFacilityInf(facility);
    }

    @PostMapping("/")
    public RespBean addFacilityInf(@RequestBody FacilityInf facility) {
        if (facilityInfService.addFacilityInf(facility) == 1) {
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
