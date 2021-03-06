package com.ffa.dao;

import com.ffa.po.FixRecordInf;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FixRecordInfMapper {
    int deleteByPrimaryKey(Integer serialNumber);

    int insert(FixRecordInf record);

    int insertSelective(FixRecordInf record);

    FixRecordInf selectByPrimaryKey(Integer serialNumber);

    int updateByPrimaryKeySelective(FixRecordInf record);

    int updateByPrimaryKey(FixRecordInf record);

    List<FixRecordInf> getAllFixRecordInf(FixRecordInf record);
}
