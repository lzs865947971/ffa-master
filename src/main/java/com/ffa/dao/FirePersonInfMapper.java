package com.ffa.dao;

import com.ffa.po.FirePersonInf;

public interface FirePersonInfMapper {
    int insert(FirePersonInf record);

    int insertSelective(FirePersonInf record);
}