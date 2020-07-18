package com.ffa.controller;

import com.ffa.dao.StaOrgPersonMapper;
import com.ffa.po.FireOrgInf;
import com.ffa.po.KeyUnit;
import com.ffa.po.vo.StaOrgPerson;
import com.ffa.service.FireOrgInfService;
import com.ffa.service.FirePersonInfService;
import com.ffa.service.KeyUnitService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sta")
public class StaController {
    @Autowired
    FireOrgInfService fireOrgInfService;
    @Autowired
    FirePersonInfService firePersonInfService;
    @Autowired
    KeyUnitService keyUnitService;
    @Autowired
    StaOrgPersonMapper staOrgPersonMapper;

    @GetMapping("/orgperson")
    public Map<String, Object> staOrgPerson(){
        String[] orgTypes = {"专职防火组织","义务防火组织","兼职防火组织"};
//        List<FireOrgInf> orgs = fireOrgInfService.getAllFireOrgInf(new FireOrgInf());
        List<KeyUnit> units = keyUnitService.getAllKeyUnit(new KeyUnit());
        List<StaOrgPerson> orgPeoples = staOrgPersonMapper.selcetStaOrgPerson();
        List unitName = new ArrayList();
        for(KeyUnit keyUnit : units)unitName.add(keyUnit.getUnitName());
        List<int[]> personNum = new ArrayList<int[]>();
        for(int k = 0; k < 3; k++){
            int[] num = new int[units.size()];
            for(int a = 0; a < units.size(); a++) num[a] = 0;
            for(int i = 0; i < units.size(); i++) {
                for (int j = 0; j < orgPeoples.size(); j++) {
                    if (units.get(i).getUnitName().equals(orgPeoples.get(j).getUnitName())) {
                        if (orgPeoples.get(j).getFireOrgTypeName().equals(orgTypes[k])) {
                            num[i] += 1;
                        }
                    }
                }
            }
            personNum.add(num);
            System.out.println(personNum.get(k).length);
        }
        Map<String, Object> map = new HashMap<>();
//        String[] us = {"u1","u2","u3","u4"};
//        int[] t1 = {1,2,3,4};
//        int[] t2 = {2,1,2,3};
//        int[] t3 = {1,1,2,4};
        map.put("unitName", unitName);
        map.put("personNum", personNum);

//        map.put("us", us);
//        map.put("t1", t1);
//        map.put("t2", t2);
//        map.put("t3", t3);
        System.out.println(map);
        return map;
    }

}
