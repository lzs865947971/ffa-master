package com.ffa.dao;

import com.ffa.po.FixRecordInf;

public interface FixRecordInfMapper {
    int insert(FixRecordInf record);

    int insertSelective(FixRecordInf record);
}