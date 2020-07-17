package com.ffa.controller;

import com.ffa.dao.StaOrgPersonMapper;
import com.ffa.po.vo.StaOrgPerson;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class StaController {
    @Mapper
    StaOrgPersonMapper staOrgPersonMapper;

//    @GetMapping("/sta/orgperson")
//    public Map staOrgPerson(){
//        List<StaOrgPerson> orgPeoples = staOrgPersonMapper.selcetStaOrgPerson();
//        List<List> personNum =
//        for(int i = 0; i < orgPeoples.size(); i++){
//

//        }
//    }

}
