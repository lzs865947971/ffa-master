package com.ffa.dao;

import com.ffa.po.vo.StaOrgPerson;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StaOrgPersonMapper {
    public List<StaOrgPerson> selcetStaOrgPerson();
}
