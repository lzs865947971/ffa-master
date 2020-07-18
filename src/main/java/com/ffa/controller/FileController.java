package com.ffa.controller;

import com.ffa.po.KeyUnit;
import com.ffa.service.KeyUnitService;
import com.ffa.utils.FastDFSUtils;
import com.ffa.po.File;
import com.ffa.po.RespBean;
import com.ffa.po.UserInf;
import com.ffa.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
//@CrossOrigin可解决跨域
@RequestMapping("/file/basic")
public class FileController {

    @Autowired
    FileService fileService;
    @Autowired
    KeyUnitService keyUnitService;

    @Value("${ffa.nginx.host}")
    String nginxHost;

    @GetMapping("/")
    public List<File> getAllFile(Authentication authentication, File file){
        UserInf userInf = (UserInf) authentication.getPrincipal();
        if(userInf.getUnitId() != null){
            file.setUnitId(userInf.getUnitId());
        }
        return fileService.getAllFile(file);
    }
    //文件上传类
    @PostMapping("/upload")
    public RespBean addFile(MultipartFile file, File fileData) {
        //获取fastdfs文件上传路径，添加到fileData数据
        String upload = FastDFSUtils.upload(file);
//        String url = nginxHost + upload;
        fileData.setFileStoragePath(upload);

        KeyUnit keyUnit = new KeyUnit();
        keyUnit.setUnitId(fileData.getUnitId());
        //为fileData设置UnitName
        fileData.setUnitName(keyUnitService.getAllKeyUnit(keyUnit).get(0).getUnitName());
        //添加日期
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        fileData.setCreateTime(sdf.format(date));

        if(fileData.getFileId() == null){
            if (fileService.addFile(fileData) == 1) {
                return RespBean.ok("添加成功!");
            }
            return RespBean.error("添加失败!");
        }
        else{
            if(fileService.updateFileById(fileData) == 1){
                return RespBean.ok("修改成功!");
            }
            return RespBean.error("修改失败!");
        }
    }
    /*
    文件下载类，调用fastdfs的downloadFile方法，向前端返回文件流格式
     */
    @GetMapping("/download")
    public ResponseEntity<byte[]> download(String fileName,String fileId) throws UnsupportedEncodingException {
        HttpHeaders headers = new HttpHeaders();
        //设置数据header
        headers.setContentDispositionFormData("attachment", new String(fileName.getBytes("UTF-8"), "ISO-8859-1"));
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        byte[] bytes = FastDFSUtils.downloadFile(fileId);
//        System.out.println(bytes);
//        System.out.println(bytes.length);
        return new ResponseEntity<byte[]>(bytes,headers, HttpStatus.CREATED);
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
