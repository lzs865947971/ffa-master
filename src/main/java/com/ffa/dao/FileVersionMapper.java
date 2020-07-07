package com.ffa.dao;

import com.ffa.po.FileVersion;

public interface FileVersionMapper {
    int insert(FileVersion record);

    int insertSelective(FileVersion record);
}