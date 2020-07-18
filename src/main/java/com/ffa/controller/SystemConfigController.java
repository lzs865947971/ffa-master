package com.ffa.controller;

import com.ffa.po.*;
import com.ffa.service.*;
import com.ffa.utils.FastDFSUtils;
import com.ffa.utils.POIUtils;
import com.ffa.utils.UserInfUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;

/*
系统查询权限控制类，提供下拉框和单位负责人、消防主管查询以及文件下载方法
 */
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
    @Autowired
    FixRecordInfService fixRecordInfService;
    @Autowired
    FileVersionService fileVersionService;
    @Autowired
    FireRecordService fireRecordService;
    @Autowired
    SecurityRisksService securityRisksService;

    /*
    系统查询权限控制类，提供下拉框和单位负责人、消防主管查询以及文件下载方法
    */

    @GetMapping("/menu")
    public List<Menu> getMenusByUId() {
        return menuService.getMenusByUId();
    }

    @GetMapping("/unit/part/")
    public List<KeyPartInf> getAllKeyPartInf(KeyPartInf keyPartInf){
        return keyPartInfService.getAllKeyPartInf(keyPartInf);
    }

    @GetMapping("/unit/basic")
    public List<KeyUnit> getAllKeyUnit(KeyUnit keyUnit){
        List<KeyUnit> keyUnitList = keyUnitService.getAllKeyUnit(keyUnit);
        //keyUnitList.stream(System.out);
        System.out.println(keyUnitList);
        return keyUnitList;
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

    @GetMapping("/facility/basic/")
    public List<FacilityInf> getAllFacilityInf(Authentication authentication, FacilityInf facility){
        UserInf userInf = (UserInf) authentication.getPrincipal();
        if(userInf.getUnitId() != null){
            facility.setUnitId(userInf.getUnitId());
        }
        return  facilityInfService.getAllFacilityInf(facility);
    }

    @GetMapping("/facility/fix/")
    public List<FixRecordInf> getAllFixRecordInf(Authentication authentication, FixRecordInf fixRecordInf){
        UserInf userInf = (UserInf) authentication.getPrincipal();
        if(userInf.getUnitId() != null){
            fixRecordInf.setUnitId(userInf.getUnitId());
        }
        return fixRecordInfService.getAllFixRecordInf(fixRecordInf);
    }

    @GetMapping("/org")
    public List<FireOrgInf> getOrgByUnitId(Integer unitId){
        FireOrgInf fireOrgInf = new FireOrgInf();
        fireOrgInf.setUnitId(unitId);
        return fireOrgInfService.getAllFireOrgInf(fireOrgInf);
    }

    @GetMapping("/org/basic/")
    public List<FireOrgInf> getAllFireOrgInf(Authentication authentication, FireOrgInf fireOrgInf){
        UserInf userInf = (UserInf) authentication.getPrincipal();
        if(userInf.getUnitId() != null){
            fireOrgInf.setUnitId(userInf.getUnitId());
        }
        return fireOrgInfService.getAllFireOrgInf(fireOrgInf);
    }

    @GetMapping("/org/person/")
    public List<FirePersonInf> getAllFirePersonInf(FirePersonInf firePersonInf){
        return firePersonInfService.getAllFirePersonInf(firePersonInf);
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

    @GetMapping("/file/basic/")
    public List<File> getAllFile(Authentication authentication, File file){
        UserInf userInf = (UserInf) authentication.getPrincipal();
        if(userInf.getUnitId() != null){
            file.setUnitId(userInf.getUnitId());
        }
        return fileService.getAllFile(file);
    }

    @GetMapping("/file/version/")
    public List<FileVersion> getAllFileVersion(FileVersion fileVersion){
        return fileVersionService.getAllFileVersion(fileVersion);
    }

    @GetMapping("/file/basic/download")
    public ResponseEntity<byte[]> download(String fileName, String fileId) throws UnsupportedEncodingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", new String(fileName.getBytes("UTF-8"), "ISO-8859-1"));
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        byte[] bytes = FastDFSUtils.downloadFile(fileId);
//        System.out.println(bytes);
//        System.out.println(bytes.length);
        return new ResponseEntity<byte[]>(bytes,headers, HttpStatus.CREATED);
    }

    @GetMapping("/fire/basic/")
    public List<FireRecord> getAllFireRecord(Authentication authentication, FireRecord fireRecord){
        UserInf userInf = (UserInf) authentication.getPrincipal();
        if(userInf.getUnitId() != null){
            fireRecord.setUnitId(userInf.getUnitId());
        }
        return fireRecordService.getAllFireRecord(fireRecord);
    }

    @GetMapping("/fire/basic/export")
    public ResponseEntity<byte[]> exportData() {
        List<FireRecord> list = (List<FireRecord>) fireRecordService.getAllFireRecord(new FireRecord());
        return POIUtils.fireRecord2Excel(list);
    }
    @GetMapping("/fire/risks/")
    public List<SecurityRisks> getAllSecurityRisks(Authentication authentication, SecurityRisks securityRisks){
        UserInf userInf = (UserInf) authentication.getPrincipal();
        if(userInf.getUnitId() != null){
            securityRisks.setUnitId(userInf.getUnitId());
        }
        return securityRisksService.getAllSecurityRisks(securityRisks);
    }
}

