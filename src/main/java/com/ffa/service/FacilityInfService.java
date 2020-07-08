package com.ffa.service;

import com.ffa.dao.UserInfMapper;
import com.ffa.po.UserInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityInfService {

    /**
     *
     */
    @Autowired
    FacilityInf ficilityInfMapper;

    public List<FacilityInf> getAllFacilityInf(){
        return facilityInfMapper.getAllFacilityInf();
    }

    public Integer addFacilityInf(FacilityInf facilityInf){
        return facilityInfMapper.insertSelective(facilityInf);
    }

    public Integer deleteFacilityInfById(Integer id){
        return facilityInfMapper.deleteByPrimaryKey(id);
    }

    public Integer updateFacilityInfById(FacilityInf facilityInf){ return facilityInfMapper.updateByPrimaryKeySelective(facilityInf); }
}
