package com.ffa.dao;

import com.ffa.po.FirePersonInf;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FirePersonInfMapper {
    int deleteByPrimaryKey(Integer firePersonId);

    int insert(FirePersonInf record);

    int insertSelective(FirePersonInf record);

    FirePersonInf selectByPrimaryKey(Integer firePersonId);

    int updateByPrimaryKeySelective(FirePersonInf record);

    int updateByPrimaryKey(FirePersonInf record);

    List<FirePersonInf> getAllFirePersonInf(FirePersonInf record);
}
