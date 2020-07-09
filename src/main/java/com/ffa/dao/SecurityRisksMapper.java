package com.ffa.dao;

import com.ffa.po.SecurityRisks;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SecurityRisksMapper {
    int deleteByPrimaryKey(Integer riskRegisterId);

    int insert(SecurityRisks record);

    int insertSelective(SecurityRisks record);

    SecurityRisks selectByPrimaryKey(Integer riskRegisterId);

    int updateByPrimaryKeySelective(SecurityRisks record);

    int updateByPrimaryKey(SecurityRisks record);

    List<SecurityRisks> getAllSecurityRisks(SecurityRisks record);
}
