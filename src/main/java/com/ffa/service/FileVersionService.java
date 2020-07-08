package com.ffa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileVersionService {

    /**
     *
     */
    @Autowired
    FileVersionMapper fileVersionMapper;

    public List<FileVersion> getAllFileVersion(){
        return fileVersionMapper.getAllFileVersion();
    }

    public Integer addFileVersion(FileVersion fileVersion){
        return fileVersionMapper.insertSelective(fileVersion);
    }

    public Integer deleteFileVersionById(Integer id){
        return fileVersionMapper.deleteByPrimaryKey(id);
    }

    public Integer updateFileVersionById(FileVersion fileVersion){ return fileVersionMapper.updateByPrimaryKeySelective(fileVersion); }
}
