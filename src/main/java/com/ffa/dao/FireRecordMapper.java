package com.ffa.dao;

import com.ffa.po.FireRecord;

public interface FireRecordMapper {
    int deleteByPrimaryKey(Integer fireId);

    int insert(FireRecord record);

    int insertSelective(FireRecord record);

    FireRecord selectByPrimaryKey(Integer fireId);

    int updateByPrimaryKeySelective(FireRecord record);

    int updateByPrimaryKey(FireRecord record);
}