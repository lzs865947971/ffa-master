package com.ffa.controller;

import com.ffa.po.KeyUnit;
import com.ffa.service.KeyUnitService;
import com.ffa.utils.POIUtils;
import com.ffa.po.FireRecord;
import com.ffa.po.RespBean;
import com.ffa.po.UserInf;
import com.ffa.service.FireRecordService;
import com.ffa.utils.UserInfUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
//@CrossOrigin可解决跨域
@RequestMapping("/fire/basic")
public class FireRecordController {

    @Autowired
    FireRecordService fireRecordService;
    @Autowired
    KeyUnitService keyUnitService;

    @GetMapping("/")
    public List<FireRecord> getAllFireRecord(Authentication authentication, FireRecord fireRecord){
        UserInf userInf = (UserInf) authentication.getPrincipal();
        if(userInf.getUnitId() != null){
            fireRecord.setUnitId(userInf.getUnitId());
        }
        return fireRecordService.getAllFireRecord(fireRecord);
    }
    @PostMapping("/")
    public RespBean addFireRecord(@RequestBody FireRecord fireRecord) {
        KeyUnit keyUnit = new KeyUnit();
        keyUnit.setUnitId(fireRecord.getUnitId());
        fireRecord.setUnitName(keyUnitService.getAllKeyUnit(keyUnit).get(0).getUnitName());
        fireRecord.setFireRecordPersonName(UserInfUtils.getCurrentUser().getName());
        if (fireRecordService.addFireRecord(fireRecord) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteFireRecordById(@PathVariable Integer id) {
        if (fireRecordService.deleteFireRecordById(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PutMapping("/")
    public RespBean updateFireRecordById(@RequestBody FireRecord fireRecord) {
        if (fireRecordService.updateFireRecordById(fireRecord) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportData() {
        List<FireRecord> list = (List<FireRecord>) fireRecordService.getAllFireRecord(new FireRecord());
        return POIUtils.fireRecord2Excel(list);
    }

    @PostMapping("/import")
    public RespBean importData(MultipartFile file) throws IOException {
        List<FireRecord> list = POIUtils.excel2FireRecord(file, keyUnitService.getAllKeyUnit(new KeyUnit()));
        if (fireRecordService.addFireRecordList(list) == list.size()) {
            return RespBean.ok("上传成功");
        }
        return RespBean.error("上传失败");
    }
}
