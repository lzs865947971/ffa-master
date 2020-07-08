package com.ffa.service;

import com.ffa.dao.UserInfMapper;
import com.ffa.po.UserInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FireRecordService {

    /**
     *
     */
    @Autowired
    FireRecordMapper FireRecordMapper;

    public List<FireRecord> getAllFireRecord(){ return fireRecordMapper.getAllFireRecord(); }

    public Integer addFireRecord(FireRecord fireRecord){
        return fireRecordMapper.insertSelective(fireRecord);
    }

    public Integer deleteFireRecordById(Integer id){
        return fireRecordMapper.deleteByPrimaryKey(id);
    }

    public Integer updateFireRecordById(FireRecord fireRecord){ return fireRecordMapper.updateByPrimaryKeySelective(fireRecord); }
}