package com.ffa.dao;

import com.ffa.po.SuperVisionInf;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SuperVisionInfMapper {
    int deleteByPrimaryKey(Integer supervisionId);

    int insert(SuperVisionInf record);

    int insertSelective(SuperVisionInf record);

    SuperVisionInf selectByPrimaryKey(Integer supervisionId);

    List<SuperVisionInf> getAllSuperVisionInf(SuperVisionInf record);

    int updateByPrimaryKeySelective(SuperVisionInf record);

    int updateByPrimaryKey(SuperVisionInf record);
}