package com.ffa.controller;

import com.ffa.po.*;
import com.ffa.service.FacilityInfService;
import com.ffa.service.KeyUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin可解决跨域
@RequestMapping("/facility/basic")
public class FacilityInfController {

    @Autowired
    FacilityInfService facilityInfService;
    @Autowired
    KeyUnitService keyUnitService;

//    @GetMapping("/")
//    public RespPageBean getAllFacilityInf(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, FacilityInf facility){
//        return facilityInfService.getEmployeeByPage(page, size, facility);
//    }
    @GetMapping("/")
    public List<FacilityInf> getAllFacilityInf(Authentication authentication, FacilityInf facility){
        UserInf userInf = (UserInf) authentication.getPrincipal();
        if(userInf.getUnitId() != null){
            facility.setUnitId(userInf.getUnitId());
        }
        return  facilityInfService.getAllFacilityInf(facility);
    }

    @PostMapping("/")
    public RespBean addFacilityInf(@RequestBody FacilityInf facility) {
        KeyUnit keyUnit = new KeyUnit();
        keyUnit.setUnitId(facility.getUnitId());
        facility.setUnitName(keyUnitService.getAllKeyUnit(keyUnit).get(0).getUnitName());
        if (facilityInfService.addFacilityInf(facility) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteFacilityInfById(@PathVariable Integer id) {
        facilityInfService.deleteFacilityInfById(id);
        return RespBean.ok("删除成功！");

    }

    @PutMapping("/")
    public RespBean updateFacilityInfById(@RequestBody FacilityInf facilityInf) {
        KeyUnit keyUnit = new KeyUnit();
        keyUnit.setUnitId(facilityInf.getUnitId());
        facilityInf.setUnitName(keyUnitService.getAllKeyUnit(keyUnit).get(0).getUnitName());
        if (facilityInfService.updateFacilityInfById(facilityInf) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

}
