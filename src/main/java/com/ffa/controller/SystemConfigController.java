package com.ffa.controller;

import com.ffa.po.*;
import com.ffa.service.*;
import com.ffa.utils.UserInfUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/system/config")
public class SystemConfigController {
    @Autowired
    MenuService menuService;
    @Autowired
    KeyPartInfService keyPartInfService;
    @Autowired
    KeyUnitService keyUnitService;
    @Autowired
    FacilityInfService facilityInfService;
    @Autowired
    FireOrgInfService fireOrgInfService;
    @Autowired
    FirePersonInfService firePersonInfService;
    @Autowired
    FileService fileService;

    @GetMapping("/menu")
    public List<Menu> getMenusByUId() {
        return menuService.getMenusByUId();
    }

    @GetMapping("/unit")
    public List<KeyUnit> getUnit(Authentication authentication){
        UserInf userInf = (UserInf) authentication.getPrincipal();
        KeyUnit keyUnit = new KeyUnit();
        if(userInf.getUnitId() != null){
            keyUnit.setUnitId(userInf.getUnitId());
        }
        return keyUnitService.getAllKeyUnit(keyUnit);
    }

    @GetMapping("/unit/info")
    public KeyUnit getUnitInfo(){
        KeyUnit keyUnit =  new KeyUnit();
        keyUnit.setUnitId(UserInfUtils.getCurrentUser().getUnitId());
        return keyUnitService.getAllKeyUnit(keyUnit).get(0);
    }

    @GetMapping("/part")
    public List<KeyPartInf> getPartByUnitId(Integer unitId){
        KeyPartInf keyPartInf = new KeyPartInf();
        keyPartInf.setUnitId(unitId);
        return keyPartInfService.getAllKeyPartInf(keyPartInf);
    }

    @GetMapping("/part/info")
    public List<KeyPartInf> getPartInfo(String keyPartName){
        KeyPartInf keyPartInf = new KeyPartInf();
        keyPartInf.setKeyPartName(keyPartName);
        keyPartInf.setUnitId(UserInfUtils.getCurrentUser().getUnitId());
        return keyPartInfService.getAllKeyPartInf(keyPartInf);
    }

    @GetMapping("/riskpart")
    public List<KeyPartInf> getPart(Authentication authentication){
        UserInf userInf = (UserInf) authentication.getPrincipal();
        KeyPartInf keyPartInf = new KeyPartInf();
        if(userInf.getUnitId() != null){
            keyPartInf.setUnitId(userInf.getUnitId());
        }
        return keyPartInfService.getAllKeyPartInf(keyPartInf);
    }

    @GetMapping("/facility")
    public List<FacilityInf> getFacilityByUnitId(Integer unitId){
        FacilityInf facilityInf = new FacilityInf();
        facilityInf.setUnitId(unitId);
        return facilityInfService.getAllFacilityInf(facilityInf);
    }

    @GetMapping("/org")
    public List<FireOrgInf> getOrgByUnitId(Integer unitId){
        FireOrgInf fireOrgInf = new FireOrgInf();
        fireOrgInf.setUnitId(unitId);
        return fireOrgInfService.getAllFireOrgInf(fireOrgInf);
    }

    @GetMapping("/allorgs")
    public List<FireOrgInf> getAllOrg(){
        FireOrgInf fireOrgInf = new FireOrgInf();
        return fireOrgInfService.getAllFireOrgInf(fireOrgInf);
    }

    @GetMapping("/person")
    public List<FirePersonInf> getPersonByOrgId(Integer orgId){
        FirePersonInf firePersonInf = new FirePersonInf();
        firePersonInf.setFireOrgId(orgId);
        return firePersonInfService.getAllFirePersonInf(firePersonInf);
    }

    @GetMapping("/file")
    public List<File> getFileByUnitId(Integer unitId){
        File file = new File();
        file.setUnitId(unitId);
        return fileService.getAllFile(file);
    }
}

