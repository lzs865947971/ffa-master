package com.ffa.dao;

import com.ffa.po.File;

public interface FileMapper {
    int deleteByPrimaryKey(Integer fileId);

    int insert(File record);

    int insertSelective(File record);

    File selectByPrimaryKey(Integer fileId);

    int updateByPrimaryKeySelective(File record);

    int updateByPrimaryKey(File record);
}