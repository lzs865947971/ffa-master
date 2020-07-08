package com.ffa.service;

import com.ffa.dao.FireOrgInfMapper;
import com.ffa.dao.UserInfMapper;
import com.ffa.po.FireOrgInf;
import com.ffa.po.UserInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FireOrgInfService {

    /**
     *
     */
    @Autowired
    FireOrgInfMapper fireOrgInfMapper;

    public List<FireOrgInf> getAllFireOrgInf(){ return fireOrgInfMapper.getAllFireOrgInf(); }

    public Integer addFireOrgInf(FireOrgInf fireOrgInf){
        return fireOrgInfMapper.insertSelective(fireOrgInf);
    }

    public Integer deleteFireOrgInfById(Integer id){
        return fireOrgInfMapper.deleteByPrimaryKey(id);
    }

    public Integer updateFireOrgInfById(FireOrgInf fireOrgInf){ return fireOrgInfMapper.updateByPrimaryKeySelective(fireOrgInf); }
}
