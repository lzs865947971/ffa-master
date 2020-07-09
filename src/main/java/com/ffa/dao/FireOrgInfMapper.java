package com.ffa.dao;

import com.ffa.po.FireOrgInf;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FireOrgInfMapper {
    int deleteByPrimaryKey(Integer fireOrgId);

    int insert(FireOrgInf record);

    int insertSelective(FireOrgInf record);

    FireOrgInf selectByPrimaryKey(Integer fireOrgId);

    int updateByPrimaryKeySelective(FireOrgInf record);

    int updateByPrimaryKey(FireOrgInf record);

    List<FireOrgInf> getAllFireOrgInf(FireOrgInf record);
}
