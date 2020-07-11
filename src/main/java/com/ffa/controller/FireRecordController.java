package com.ffa.controller;

import com.ffa.po.FireRecord;
import com.ffa.po.RespBean;
import com.ffa.service.FireRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin可解决跨域
@RequestMapping("/fire/basic")
public class FireRecordController {

    @Autowired
    FireRecordService fireRecordService;


    @GetMapping("/")
    public List<FireRecord> getAllFireRecord(@RequestBody FireRecord fireRecord){
        return fireRecordService.getAllFireRecord(fireRecord);
    }
    @PostMapping("/")
    public RespBean addFireRecord(@RequestBody FireRecord fireRecord) {
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

}
