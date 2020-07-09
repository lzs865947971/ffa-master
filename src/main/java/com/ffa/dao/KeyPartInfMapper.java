package com.ffa.dao;

import com.ffa.po.KeyPartInf;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KeyPartInfMapper {
    int deleteByPrimaryKey(Integer keyPartId);

    int insert(KeyPartInf record);

    int insertSelective(KeyPartInf record);

    KeyPartInf selectByPrimaryKey(Integer keyPartId);

    List<KeyPartInf> getAllKeyPartInf(KeyPartInf record);

    int updateByPrimaryKeySelective(KeyPartInf record);

    int updateByPrimaryKey(KeyPartInf record);
}
