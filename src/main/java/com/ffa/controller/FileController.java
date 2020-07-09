package com.ffa.controller;

import com.ffa.po.File;
import com.ffa.po.RespBean;
import com.ffa.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin可解决跨域
@RequestMapping("/file")
public class FileController {

    @Autowired
    FileService fileService;


    @GetMapping("/")
    public List<File> getAllFile(@RequestBody File file){
        return fileService.getAllFile(file);
    }
    @PostMapping("/")
    public RespBean addFile(@RequestBody File file) {
        if (fileService.addFile(file) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }


    @DeleteMapping("/{id}")
    public RespBean deleteFileById(@PathVariable Integer id) {
        if (fileService.deleteFileById(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PutMapping("/")
    public RespBean updateFileById(@RequestBody File file) {
        if (fileService.updateFileById(file) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

}
