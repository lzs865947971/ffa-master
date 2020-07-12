package com.ffa.dao;

import com.ffa.po.FacilityInf;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface FacilityInfMapper {
    int deleteByPrimaryKey(Integer facilityId);

    int insert(FacilityInf record);

    int insertSelective(FacilityInf record);

    FacilityInf selectByPrimaryKey(Integer facilityId);

    int updateByPrimaryKeySelective(FacilityInf record);

    int updateByPrimaryKey(FacilityInf record);

//    Long getTotal(@Param("facility") FacilityInf facility);
//
//    List<FacilityInf> getAllFacilityInf(@Param("page") Integer page, @Param("size") Integer size, @Param("facility") FacilityInf facility);
    List<FacilityInf> getAllFacilityInf(FacilityInf facility);
}
