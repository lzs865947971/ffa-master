package com.ffa.service;

import com.ffa.dao.FixRecordInfMapper;
import com.ffa.dao.UserInfMapper;
import com.ffa.po.FixRecordInf;
import com.ffa.po.UserInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FixRecordInfService {

    /**
     *
     */
    @Autowired
    FixRecordInfMapper fixRecordInfMapper;

    public List<FixRecordInf> getAllFixRecordInf(){
        return fixRecordInfMapper.getAllFixRecordInf();
    }

    public Integer addFixRecordInf(FixRecordInf fixRecordInf){
        return fixRecordInfMapper.insertSelective(fixRecordInf);
    }

    public Integer deleteUserInfFixRecordInfById(Integer id){
        return fixRecordInfMapper.deleteByPrimaryKey(id);
    }

    public Integer updateFixRecordInfById(FixRecordInf fixRecordInf){
        return fixRecordInfMapper.updateByPrimaryKeySelective(fixRecordInf);
    }
}
