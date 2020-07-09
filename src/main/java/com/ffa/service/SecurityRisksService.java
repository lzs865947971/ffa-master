package com.ffa.service;

import com.ffa.dao.SecurityRisksMapper;
import com.ffa.po.SecurityRisks;
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

    public List<SecurityRisks> getAllSecurityRisks(SecurityRisks securityRisks){
        return securityRisksMapper.getAllSecurityRisks(securityRisks);
    }


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
