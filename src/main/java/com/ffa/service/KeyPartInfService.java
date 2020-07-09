package com.ffa.service;

import com.ffa.dao.KeyPartInfMapper;
import com.ffa.po.KeyPartInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeyPartInfService {

    /**
     *
     */
    @Autowired
    KeyPartInfMapper keyPartInfMapper;

    public List<KeyPartInf> getAllKeyPartInf(KeyPartInf keyPartInf){
        return keyPartInfMapper.getAllKeyPartInf(keyPartInf);
    }

    public Integer addKeyPartInf(KeyPartInf keyPartInf){
        return keyPartInfMapper.insertSelective(keyPartInf);
    }

    public Integer deleteKeyPartInfById(Integer id){
        return keyPartInfMapper.deleteByPrimaryKey(id);
    }

    public Integer updateKeyPartInfById(KeyPartInf keyPartInf){
        return keyPartInfMapper.updateByPrimaryKeySelective(keyPartInf);
    }
}
