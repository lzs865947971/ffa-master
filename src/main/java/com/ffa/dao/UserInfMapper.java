package com.ffa.dao;

import com.ffa.po.UserInf;

public interface UserInfMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserInf record);

    int insertSelective(UserInf record);

    UserInf selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserInf record);

    int updateByPrimaryKey(UserInf record);
}