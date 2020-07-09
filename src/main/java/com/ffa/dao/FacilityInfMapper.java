package com.ffa.dao;

import com.ffa.po.FacilityInf;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FacilityInfMapper {
    int deleteByPrimaryKey(Integer facilityId);

    int insert(FacilityInf record);

    int insertSelective(FacilityInf record);

    FacilityInf selectByPrimaryKey(Integer facilityId);

    int updateByPrimaryKeySelective(FacilityInf record);

    int updateByPrimaryKey(FacilityInf record);


    List<FacilityInf> getAllFacilityInf(FacilityInf record);
}