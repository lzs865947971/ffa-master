package com.ffa.dao;

import com.ffa.po.KeyUnit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KeyUnitMapper {
    int deleteByPrimaryKey(Integer unitId);

    int insert(KeyUnit record);

    int insertSelective(KeyUnit record);

    KeyUnit selectByPrimaryKey(Integer unitId);

    List<KeyUnit> getAllKeyUnit(KeyUnit record);

    int updateByPrimaryKeySelective(KeyUnit record);

    int updateByPrimaryKey(KeyUnit record);
}