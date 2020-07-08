package com.ffa.dao;

import com.ffa.po.FirePersonInf;

public interface FirePersonInfMapper {
    int deleteByPrimaryKey(Integer firePersonId);

    int insert(FirePersonInf record);

    int insertSelective(FirePersonInf record);

    FirePersonInf selectByPrimaryKey(Integer firePersonId);

    int updateByPrimaryKeySelective(FirePersonInf record);

    int updateByPrimaryKey(FirePersonInf record);
}