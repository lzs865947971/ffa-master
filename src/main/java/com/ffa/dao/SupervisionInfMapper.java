package com.ffa.dao;

import com.ffa.po.SupervisionInf;

public interface SupervisionInfMapper {
    int deleteByPrimaryKey(Integer supervisionId);

    int insert(SupervisionInf record);

    int insertSelective(SupervisionInf record);

    SupervisionInf selectByPrimaryKey(Integer supervisionId);

    int updateByPrimaryKeySelective(SupervisionInf record);

    int updateByPrimaryKey(SupervisionInf record);
}