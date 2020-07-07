package com.ffa.dao;

import com.ffa.po.UserInf;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(UserInf record);

    int insertSelective(UserInf record);

    UserInf selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(UserInf record);

    int updateByPrimaryKey(UserInf record);

    List<UserInf> getAllUseInf();
}
