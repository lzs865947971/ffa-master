package com.ffa.dao;

import com.ffa.po.KeyPartInf;

public interface KeyPartInfMapper {
    int deleteByPrimaryKey(Integer keyPartId);

    int insert(KeyPartInf record);

    int insertSelective(KeyPartInf record);

    KeyPartInf selectByPrimaryKey(Integer keyPartId);

    int updateByPrimaryKeySelective(KeyPartInf record);

    int updateByPrimaryKey(KeyPartInf record);
}