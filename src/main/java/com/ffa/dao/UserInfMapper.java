package com.ffa.dao;

import com.ffa.po.Role;
import com.ffa.po.UserInf;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserInfMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserInf record);

    int insertSelective(UserInf record);

    UserInf selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserInf record);

    int updateByPrimaryKey(UserInf record);

    UserInf loadUserByUsername(String username);

    List<Role> getUserRolesById(Integer id);

    List<UserInf> getAllUsers(@Param("uid") Integer uid, @Param("keywords") String keywords);

    List<UserInf> getAllUsersExceptCurrentHr(Integer id);

    Integer updatePasswd(@Param("uid") Integer uid, @Param("encodePass") String encodePass);

   // Integer updateUserface(@Param("url") String url, @Param("id") Integer id);
}
