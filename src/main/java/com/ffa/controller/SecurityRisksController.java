package com.ffa.controller;

import com.ffa.po.*;
import com.ffa.service.KeyPartInfService;
import com.ffa.service.KeyUnitService;
import com.ffa.service.SecurityRisksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin可解决跨域
@RequestMapping("/fire/risks")
public class SecurityRisksController {

    @Autowired
    SecurityRisksService securityRisksService;
    @Autowired
    KeyUnitService keyUnitService;
    @Autowired
    KeyPartInfService keyPartInfService;

    @GetMapping("/")
    public List<SecurityRisks> getAllSecurityRisks(Authentication authentication, SecurityRisks securityRisks){
        UserInf userInf = (UserInf) authentication.getPrincipal();
        if(userInf.getUnitId() != null){
            securityRisks.setUnitId(userInf.getUnitId());
        }
        return securityRisksService.getAllSecurityRisks(securityRisks);
    }

    public SecurityRisks addParamToFixRecordInf(SecurityRisks securityRisks){
        KeyUnit keyUnit = new KeyUnit();
        keyUnit.setUnitId(securityRisks.getUnitId());
        securityRisks.setUnitName(keyUnitService.getAllKeyUnit(keyUnit).get(0).getUnitName());
        KeyPartInf keyPartInf = new KeyPartInf();
        keyPartInf.setKeyPartId(securityRisks.getRiskKeyPartId());
        securityRisks.setRiskKeyPartName(keyPartInfService.getAllKeyPartInf(keyPartInf).get(0).getKeyPartName());
        return securityRisks;
    }

    @PostMapping("/")
    public RespBean addSecurityRisks(@RequestBody SecurityRisks securityRisks) {
        try{
            if (securityRisksService.addSecurityRisks(addParamToFixRecordInf(securityRisks)) == 1) {
                return RespBean.ok("添加成功!");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteSecurityRisksById(@PathVariable Integer id) {
        if (securityRisksService.deleteSecurityRisksById(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PutMapping("/")
    public RespBean updateSecurityRisksById(@RequestBody SecurityRisks securityRisks) {
        try{
            if (securityRisksService.updateSecurityRisksById(addParamToFixRecordInf(securityRisks)) == 1) {
                return RespBean.ok("添加成功!");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return RespBean.error("更新失败!");
    }

}
