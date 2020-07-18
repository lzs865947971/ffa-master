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

    //查询方法
    @GetMapping("/")
    public List<KeyPartInf> getAllKeyPartInf(KeyPartInf keyPartInf){
        return keyPartInfService.getAllKeyPartInf(keyPartInf);
    }
    //添加方法
    @PostMapping("/")
    public RespBean addKeyPartInf(@RequestBody KeyPartInf keyPartInf) {
        if (keyPartInfService.addKeyPartInf(keyPartInf) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    //删除方法
    @DeleteMapping("/{id}")
    public RespBean deleteKeyPartInfById(@PathVariable Integer id) {
        if (keyPartInfService.deleteKeyPartInfById(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    //更新方法
    @PutMapping("/")
    public RespBean updateKeyPartInfById(@RequestBody KeyPartInf keyPartInf) {
        if (keyPartInfService.updateKeyPartInfById(keyPartInf) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @Value("${ffa.nginx.host}")
    String nginxHost;

    //总体平面图上传方法
    @PostMapping("/upload")
    public RespBean addFile(MultipartFile file, KeyPartInf keyPartInf) {
        //获取fastdfs上传文件地址
        String upload = FastDFSUtils.upload(file);
        String url = nginxHost + upload;
        //添加文件url
        keyPartInf.setKeyPartPicId(url);
        KeyUnit keyUnit = new KeyUnit();
        //添加单位id
        keyUnit.setUnitId(keyPartInf.getUnitId());
        keyPartInf.setUnitName(keyUnitService.getAllKeyUnit(keyUnit).get(0).getUnitName());
        //判断partId是否为空？调用添加方法：调用更新方法
        if(keyPartInf.getKeyPartId() != null){
            if(keyPartInfService.updateKeyPartInfById(keyPartInf) == 1){
                return RespBean.ok("修改成功!");
            }
            return RespBean.error("修改失败!");
        }
        else{
            if (keyPartInfService.addKeyPartInf(keyPartInf) == 1) {
                return RespBean.ok("添加成功!");
            }
            return RespBean.error("添加失败!");

        }
    }
}
