package com.ffa.dao;

import com.ffa.po.FacilityInf;

public interface FacilityInfMapper {
    int deleteByPrimaryKey(Integer facilityId);

    int insert(FacilityInf record);

    int insertSelective(FacilityInf record);

    FacilityInf selectByPrimaryKey(Integer facilityId);

    int updateByPrimaryKeySelective(FacilityInf record);

    int updateByPrimaryKey(FacilityInf record);


}