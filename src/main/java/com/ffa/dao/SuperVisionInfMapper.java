package com.ffa.dao;

import com.ffa.po.SuperVisionInf;

public interface SuperVisionInfMapper {
    int deleteByPrimaryKey(Integer supervisionId);

    int insert(SuperVisionInf record);

    int insertSelective(SuperVisionInf record);

    SuperVisionInf selectByPrimaryKey(Integer supervisionId);

    int updateByPrimaryKeySelective(SuperVisionInf record);

    int updateByPrimaryKey(SuperVisionInf record);
}