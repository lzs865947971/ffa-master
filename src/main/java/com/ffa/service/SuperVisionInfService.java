package com.ffa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperVisionInfService {

    /**
     *
     */
    @Autowired
    SuperVisionInfMapper superVisionInfMapper;

    public List<SuperVisionInf> getAllSuperVisionInf(){
        return superVisionInfMapper.getAllSuperVisionInf();
    }

    public Integer addSuperVisionInf(SuperVisionInf superVisionInf){
        return superVisionInfMapper.insertSelective(superVisionInf);
    }

    public Integer deleteSuperVisionInfById(Integer id){
        return superVisionInfMapper.deleteByPrimaryKey(id);
    }

    public Integer updateSuperVisionInfById(SuperVisionInf superVisionInf){
        return superVisionInfMapper.updateByPrimaryKeySelective(superVisionInf);
    }
}
