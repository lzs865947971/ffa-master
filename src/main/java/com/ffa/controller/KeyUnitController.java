package com.ffa.controller;

import com.ffa.utils.FastDFSUtils;
import com.ffa.po.KeyUnit;
import com.ffa.po.RespBean;
import com.ffa.service.KeyUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
//@CrossOrigin可解决跨域
@RequestMapping("/unit/basic")
public class KeyUnitController {

    @Autowired
    KeyUnitService keyUnitService;

    //查询方法
    @GetMapping("/")
    public List<KeyUnit> getAllKeyUnit(KeyUnit keyUnit){
        List<KeyUnit> keyUnitList = keyUnitService.getAllKeyUnit(keyUnit);
        //keyUnitList.stream(System.out);
        System.out.println(keyUnitList);
        return keyUnitList;
    }

    //查询方法
    @GetMapping("/list")
    public List<KeyUnit> getAllKeyUnit(){
        KeyUnit keyUnit = new KeyUnit();
        List<KeyUnit> keyUnitList = keyUnitService.getAllKeyUnit(keyUnit);
        //keyUnitList.stream(System.out);
        System.out.println(keyUnitList);
        return keyUnitList;
    }

    //添加方法
    @PostMapping("/")
    public RespBean addKeyUnit(@RequestBody KeyUnit keyUnit) {
        if (keyUnitService.addKeyUnit(keyUnit) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    //删除方法
    @DeleteMapping("/{id}")
    public RespBean deleteKeyUnitById(@PathVariable Integer id) {
        keyUnitService.deleteKeyUnitById(id);
        return RespBean.ok("删除成功！");
    }

    //更新方法
    @PutMapping("/")
    public RespBean updateKeyUnitById(@RequestBody KeyUnit keyUnit) {
        if (keyUnitService.updateKeyUnitById(keyUnit) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @Value("${ffa.nginx.host}")
    String nginxHost;

    //部位平面布局图上传方法
    @PostMapping("/upload")
    public RespBean addFile(MultipartFile file, KeyUnit keyUnit) {
        //获取fastdfs上传文件地址
        String upload = FastDFSUtils.upload(file);
        String url = nginxHost + upload;
        //添加文件地址
        keyUnit.setOverallPictureId(url);
        //判断partId是否为空？调用添加方法：调用更新方法
        if(keyUnit.getUnitId() == null){
            if (keyUnitService.addKeyUnit(keyUnit) == 1) {
                return RespBean.ok("添加成功!");
            }
            return RespBean.error("添加失败!");
        }
        else{
            if(keyUnitService.updateKeyUnitById(keyUnit) == 1){
                return RespBean.ok("修改成功!");
            }
            return RespBean.error("修改失败!");
        }
    }

}
