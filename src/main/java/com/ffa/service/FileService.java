package com.ffa.service;

import com.ffa.dao.FileMapper;
import com.ffa.dao.FileVersionMapper;
import com.ffa.po.File;
import com.ffa.po.FileVersion;
import com.ffa.po.UserInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    /**
     *
     */
    @Autowired
    FileMapper fileMapper;
    @Autowired
    FileVersionMapper fileVersionMapper;

    public List<File> getAllFile(File file){
        return fileMapper.getAllFile(file);
    }

    public Integer addFile(File file){
        return fileMapper.insertSelective(file);
    }

    public Integer deleteFileById(Integer id){
        return fileMapper.deleteByPrimaryKey(id);
    }

    public Integer updateFileById(File file){
        File oldFile = fileMapper.selectByPrimaryKey(file.getFileId());
        FileVersion fileVersion = new FileVersion();
        fileVersion.setFileId(oldFile.getFileId());
        fileVersion.setPerfile(oldFile.getFileStoragePath());
//        UserInf userInf = (UserInf) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        fileVersionMapper.insertSelective(fileVersion);
        return fileMapper.updateByPrimaryKeySelective(file);
    }
}
