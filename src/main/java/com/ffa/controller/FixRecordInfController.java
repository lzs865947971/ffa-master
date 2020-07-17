package com.ffa.controller;

import com.ffa.po.*;
import com.ffa.service.FacilityInfService;
import com.ffa.service.FixRecordInfService;
import com.ffa.service.KeyUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin可解决跨域
@RequestMapping("/facility/fix")
public class FixRecordInfController {

    @Autowired
    FixRecordInfService fixRecordInfService;
    @Autowired
    KeyUnitService keyUnitService;
    @Autowired
    FacilityInfService facilityInfService;

    @GetMapping("/")
    public List<FixRecordInf> getAllFixRecordInf(Authentication authentication, FixRecordInf fixRecordInf){
        UserInf userInf = (UserInf) authentication.getPrincipal();
        if(userInf.getUnitId() != null){
            fixRecordInf.setUnitId(userInf.getUnitId());
        }
        return fixRecordInfService.getAllFixRecordInf(fixRecordInf);
    }

    public FixRecordInf addParamToFixRecordInf(FixRecordInf fixRecordInf){
        KeyUnit keyUnit = new KeyUnit();
        keyUnit.setUnitId(fixRecordInf.getUnitId());
        fixRecordInf.setUnitName(keyUnitService.getAllKeyUnit(keyUnit).get(0).getUnitName());
        FacilityInf facilityInf = new FacilityInf();
        facilityInf.setFacilityId(fixRecordInf.getFacilityId());
        fixRecordInf.setFacilityName(facilityInfService.getAllFacilityInf(facilityInf).get(0).getFacilityName());
        return fixRecordInf;
    }

    @PostMapping("/")
    public RespBean addFixRecordInf(@RequestBody FixRecordInf fixRecordInf) {
        if (fixRecordInfService.addFixRecordInf(addParamToFixRecordInf(fixRecordInf)) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteFixRecordInfById(@PathVariable Integer id) {
        if (fixRecordInfService.deleteFixRecordInfById(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PutMapping("/")
    public RespBean updateFixRecordInfById(@RequestBody FixRecordInf fixRecordInf) {
        if (fixRecordInfService.updateFixRecordInfById(addParamToFixRecordInf(fixRecordInf)) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

}
