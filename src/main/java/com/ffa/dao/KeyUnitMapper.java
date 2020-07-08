package com.ffa.dao;

import com.ffa.po.KeyUnit;

public interface KeyUnitMapper {
    int deleteByPrimaryKey(Integer unitId);

    int insert(KeyUnit record);

    int insertSelective(KeyUnit record);

    KeyUnit selectByPrimaryKey(Integer unitId);

    int updateByPrimaryKeySelective(KeyUnit record);

    int updateByPrimaryKey(KeyUnit record);
}