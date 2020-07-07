package com.ffa.dao;

import com.ffa.po.FireOrgInf;

public interface FireOrgInfMapper {
    int deleteByPrimaryKey(Integer fireOrgId);

    int insert(FireOrgInf record);

    int insertSelective(FireOrgInf record);

    FireOrgInf selectByPrimaryKey(Integer fireOrgId);

    int updateByPrimaryKeySelective(FireOrgInf record);

    int updateByPrimaryKey(FireOrgInf record);
}