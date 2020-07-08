package com.ffa.dao;

import com.ffa.po.SecurityRisks;

public interface SecurityRisksMapper {
    int deleteByPrimaryKey(Integer riskRegisterId);

    int insert(SecurityRisks record);

    int insertSelective(SecurityRisks record);

    SecurityRisks selectByPrimaryKey(Integer riskRegisterId);

    int updateByPrimaryKeySelective(SecurityRisks record);

    int updateByPrimaryKey(SecurityRisks record);
}