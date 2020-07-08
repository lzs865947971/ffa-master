package com.ffa.controller;

import com.ffa.po.FileVersion;
import com.ffa.po.RespBean;
import com.ffa.po.UserInf;
import com.ffa.service.FileVersionService;
import com.ffa.service.UserInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin可解决跨域
@RequestMapping("/user")
public class FileVersionController {

    @Autowired
    FileVersionService fileVersionService;

    //获取全部用户
    @GetMapping("/")
    public List<FileVersion> getAllFileVersion(){
        return fileVersionService.getAllFileVersion();
    }
    @PostMapping("/")
    public RespBean addFileVersion(@RequestBody FileVersion fileVersion) {
        if (fileVersionService.addFileVersion(fileVersion) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteFileVersionById(@PathVariable Integer id) {
        if (fileVersionService.deleteFileVersionById(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PutMapping("/")
    public RespBean updateFileVersionById(@RequestBody FileVersion fileVersion) {
        if (fileVersionService.updateFileVersionById(fileVersion) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

}
