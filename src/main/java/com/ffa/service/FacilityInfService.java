package com.ffa.service;

import com.ffa.dao.FacilityInfMapper;
import com.ffa.po.FacilityInf;
import com.ffa.po.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FacilityInfService {
    /**
     *
     */
    @Autowired
    FacilityInfMapper facilityInfMapper;

    public List<FacilityInf> getAllFacilityInf(FacilityInf facilityInf){
        return facilityInfMapper.getAllFacilityInf(facilityInf);
    }

//    public RespPageBean getEmployeeByPage(Integer page, Integer size, FacilityInf facility) {
//        if (page != null && size != null) {
//            page = (page - 1) * size;
//        }
//        List<FacilityInf> data = facilityInfMapper.getAllFacilityInf(page, size, facility);
//        Long total = facilityInfMapper.getTotal(facility);
//        RespPageBean bean = new RespPageBean();
//        bean.setData(data);
//        bean.setTotal(total);
//        return bean;
//    }

    public Integer addFacilityInf(FacilityInf facilityInf){
        return facilityInfMapper.insertSelective(facilityInf);
    }

    public Integer deleteFacilityInfById(Integer id){
        return facilityInfMapper.deleteByPrimaryKey(id);
    }

    public Integer updateFacilityInfById(FacilityInf facilityInf)
    {
        return facilityInfMapper.updateByPrimaryKeySelective(facilityInf);
    }
}
