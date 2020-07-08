package com.ffa.dao;

import com.ffa.po.FileVersion;

public interface FileVersionMapper {
    int deleteByPrimaryKey(Integer serialNumber);

    int insert(FileVersion record);

    int insertSelective(FileVersion record);

    FileVersion selectByPrimaryKey(Integer serialNumber);

    int updateByPrimaryKeySelective(FileVersion record);

    int updateByPrimaryKey(FileVersion record);
}