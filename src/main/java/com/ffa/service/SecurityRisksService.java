package com.ffa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityRisksService {

    /**
     *
     */
    @Autowired
    SecurityRisksMapper securityRisksMapper;

    public List<SecurityRisks> getAllSecurityRisks(){
        return securityRisksMapper.getAllSecurityRisks();
    }

    public List<SecurityRisks>

    public Integer addSecurityRisks(SecurityRisks securityRisks){
        return securityRisksMapper.insertSelective(securityRisks);
    }

    public Integer deleteSecurityRisksById(Integer id){
        return securityRisksMapper.deleteByPrimaryKey(id);
    }

    public Integer updateSecurityRisksById(SecurityRisks securityRisks){
        return securityRisksMapper.updateByPrimaryKeySelective(securityRisks);
    }
}
