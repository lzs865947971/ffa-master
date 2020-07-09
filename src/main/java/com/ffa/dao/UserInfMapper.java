package com.ffa.dao;

import com.ffa.po.UserInf;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfMapper {

    int deleteByPrimaryKey(Integer userId);

    int insert(UserInf record);

    int insertSelective(UserInf record);

    List<UserInf> getAllUserInf();

    UserInf selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserInf record);

    int updateByPrimaryKey(UserInf record);
}