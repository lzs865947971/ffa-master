package com.ffa.service;

import com.ffa.dao.FirePersonInfMapper;
import com.ffa.po.FirePersonInf;
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

    public List<FirePersonInf> getAllFirePersonInf(FirePersonInf firePersonInf){
        return firePersonInfMapper.getAllFirePersonInf(firePersonInf);
    }

    public Integer addFirePersonInf(FirePersonInf firePersonInf){ return firePersonInfMapper.insertSelective(firePersonInf); }

    public Integer deleteFirePersonInfById(Integer id){
        return firePersonInfMapper.deleteByPrimaryKey(id);
    }

    public Integer updateFirePersonInfById(FirePersonInf firePersonInf){ return firePersonInfMapper.updateByPrimaryKeySelective(firePersonInf); }


}
