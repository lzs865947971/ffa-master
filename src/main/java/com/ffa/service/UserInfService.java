package com.ffa.service;

import com.ffa.dao.UserInfMapper;
import com.ffa.po.UserInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfService {

    /**
     *
     */
    @Autowired
    UserInfMapper userInfMapper;

    public List<UserInf> getAllUseInf(){
        return userInfMapper.getAllUseInf();
    }

    public Integer addUserInf(UserInf userInf){
        return userInfMapper.insertSelective(userInf);
    }

    public Integer deleteUserInfById(Integer id){
        return userInfMapper.deleteByPrimaryKey(id);
    }

    public Integer updateUserInfById(UserInf userInf){
        return userInfMapper.updateByPrimaryKeySelective(userInf);
    }
}
