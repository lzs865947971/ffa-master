package com.ffa.service;

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

    public Integer deleteFixRecordInfById(Integer id){
        return fixRecordInfMapper.deleteByPrimaryKey(id);
    }

    public Integer updateFixRecordInfById(FixRecordInf fixRecordInf){
        return fixRecordInfMapper.updateByPrimaryKeySelective(fixRecordInf);
    }
}
