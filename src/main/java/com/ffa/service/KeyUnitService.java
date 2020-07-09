package com.ffa.service;

import com.ffa.dao.KeyUnitMapper;
import com.ffa.po.KeyUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeyUnitService {

    /**
     *
     */
    @Autowired
    KeyUnitMapper keyUnitMapper;

    public List<KeyUnit> getAllKeyUnit(KeyUnit keyUnit){
        return keyUnitMapper.getAllKeyUnit(keyUnit);
    }

    public Integer addKeyUnit(KeyUnit keyUnit){
        return keyUnitMapper.insertSelective(keyUnit);
    }

    public Integer deleteKeyUnitById(Integer id){
        return keyUnitMapper.deleteByPrimaryKey(id);
    }

    public Integer updateKeyUnitById(KeyUnit keyUnit){
        return keyUnitMapper.updateByPrimaryKeySelective(keyUnit);
    }
}
