package com.ffa.controller;

import com.ffa.po.FireOrgInf;
import com.ffa.service.FireOrgInfService;
import com.ffa.utils.FastDFSUtils;
import com.ffa.po.FirePersonInf;
import com.ffa.po.RespBean;
import com.ffa.service.FirePersonInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
//@CrossOrigin可解决跨域
@RequestMapping("/org/person")
public class FirePersonInfController {

    @Autowired
    FirePersonInfService firePersonInfService;
    @Autowired
    FireOrgInfService fireOrgInfService;

    //查询方法
    @GetMapping("/")
    public List<FirePersonInf> getAllFirePersonInf(FirePersonInf firePersonInf){
        return firePersonInfService.getAllFirePersonInf(firePersonInf);
    }

    //添加方法
    @PostMapping("/")
    public RespBean addFirePersonInf(@RequestBody FirePersonInf firePersonInf) {
        if (firePersonInfService.addFirePersonInf(firePersonInf) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    //删除方法
    @DeleteMapping("/{id}")
    public RespBean deleteFirePersonInfById(@PathVariable Integer id) {
        if (firePersonInfService.deleteFirePersonInfById(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    //修改方法
    @PutMapping("/")
    public RespBean updateFirePersonInfById(@RequestBody FirePersonInf firePersonInf) {
        if (firePersonInfService.updateFirePersonInfById(firePersonInf) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @Value("${ffa.nginx.host}")
    String nginxHost;

    /*
    上传防火人员照片方法
     */
    @PostMapping("/upload")
    public RespBean addFile(MultipartFile file, FirePersonInf firePersonInf) {
        //获取fastdfs上传路径
        String upload = FastDFSUtils.upload(file);
        //为路径添加服务器ip地址
        String url = nginxHost + upload;
        firePersonInf.setFirePersonPicId(url);
        FireOrgInf fireOrgInf = new FireOrgInf();
        fireOrgInf.setFireOrgId(firePersonInf.getFireOrgId());
        //添加所属组织名称
        firePersonInf.setFireOrgName(fireOrgInfService.getAllFireOrgInf(fireOrgInf).get(0).getFireOrgName());
        if (firePersonInf.getFirePersonId() == null){
            if(firePersonInfService.addFirePersonInf(firePersonInf) == 1){
                return RespBean.ok("添加成功!");
            }
            return RespBean.error("添加失败!");
        }
        else{
            if(firePersonInfService.updateFirePersonInfById(firePersonInf) == 1){
                return RespBean.ok("修改成功!");
            }
            return RespBean.error("修改失败!");
        }
    }

}
