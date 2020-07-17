package com.ffa.controller;

import com.ffa.utils.FastDFSUtils;
import com.ffa.po.KeyPartInf;
import com.ffa.po.KeyUnit;
import com.ffa.po.RespBean;
import com.ffa.service.KeyPartInfService;
import com.ffa.service.KeyUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
//@CrossOrigin可解决跨域
@RequestMapping("/unit/part")
public class KeyPartInfController {

    @Autowired
    KeyPartInfService keyPartInfService;

    @Autowired
    KeyUnitService keyUnitService;

    @GetMapping("/")
    public List<KeyPartInf> getAllKeyPartInf(KeyPartInf keyPartInf){
        return keyPartInfService.getAllKeyPartInf(keyPartInf);
    }
    @PostMapping("/")
    public RespBean addKeyPartInf(@RequestBody KeyPartInf keyPartInf) {
        if (keyPartInfService.addKeyPartInf(keyPartInf) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteKeyPartInfById(@PathVariable Integer id) {
        if (keyPartInfService.deleteKeyPartInfById(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PutMapping("/")
    public RespBean updateKeyPartInfById(@RequestBody KeyPartInf keyPartInf) {
        if (keyPartInfService.updateKeyPartInfById(keyPartInf) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @Value("${ffa.nginx.host}")
    String nginxHost;

    @PostMapping("/upload")
    public RespBean addFile(MultipartFile file, KeyPartInf keyPartInf) {
        String upload = FastDFSUtils.upload(file);
        String url = nginxHost + upload;
        keyPartInf.setKeyPartPicId(url);
        KeyUnit keyUnit = new KeyUnit();
        keyUnit.setUnitId(keyPartInf.getUnitId());
        keyPartInf.setUnitName(keyUnitService.getAllKeyUnit(keyUnit).get(0).getUnitName());
        if(keyPartInf.getKeyPartId() == null){
            if (keyPartInfService.addKeyPartInf(keyPartInf) == 1) {
                return RespBean.ok("添加成功!");
            }
            return RespBean.error("添加失败!");
        }
        else{
            if(keyPartInfService.updateKeyPartInfById(keyPartInf) == 1){
                return RespBean.ok("修改成功!");
            }
            return RespBean.error("修改失败!");
        }
    }
}
