package com.ffa.service;

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

    public List<File> getAllFile(){
        return fileMapper.getAllFile();
    }

    public Integer addFile(File file){
        return fileMapper.insertSelective(file);
    }

    public Integer deleteFileById(Integer id){
        return fileMapper.deleteByPrimaryKey(id);
    }

    public Integer updateFileById(File file){
        return fileMapper.updateByPrimaryKeySelective(file);
    }
}
