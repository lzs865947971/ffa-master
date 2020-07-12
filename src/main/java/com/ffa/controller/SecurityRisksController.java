package com.ffa.controller;

import com.ffa.po.RespBean;
import com.ffa.po.SecurityRisks;
import com.ffa.service.SecurityRisksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin可解决跨域
@RequestMapping("/fire/risks")
public class SecurityRisksController {

    @Autowired
    SecurityRisksService securityRisksService;


    @GetMapping("/")
    public List<SecurityRisks> getAllSecurityRisks(@RequestBody SecurityRisks securityRisks){
        return securityRisksService.getAllSecurityRisks(securityRisks);
    }
    @PostMapping("/")
    public RespBean addSecurityRisks(@RequestBody SecurityRisks securityRisks) {
        if (securityRisksService.addSecurityRisks(securityRisks) == 1) {
            return RespBean.ok("添加成功!");
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
        if (securityRisksService.updateSecurityRisksById(securityRisks) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

}
