package com.ffa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirePersonInfService {

    /**
     *
     */
    @Autowired
    FirePersonInfMapper firePersonInfMapper;

    public List<FirePersonInf> getAllFirePersonInf(){
        return firePersonInfMapper.getAllFirePersonInf();
    }

    public Integer addFirePersonInf(FirePersonInf firePersonId){ return firePersonInfMapper.insertSelective(firePersonInf); }

    public Integer deleteFirePersonInfById(Integer id){
        return firePersonInfMapper.deleteByPrimaryKey(id);
    }

    public Integer updateFirePersonInfById(FirePersonInf firePersonInf){ return firePersonInfMapper.updateByPrimaryKeySelective(firePersonInf); }
}
