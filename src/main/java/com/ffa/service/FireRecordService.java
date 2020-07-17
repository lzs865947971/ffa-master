package com.ffa.service;

import com.ffa.dao.FireRecordMapper;
import com.ffa.po.FireRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class FireRecordService {

    /**
     *
     */
    @Autowired
    FireRecordMapper fireRecordMapper;

    public List<FireRecord> getAllFireRecord(FireRecord fireRecord){ return fireRecordMapper.getAllFireRecord(fireRecord); }

    public Integer addFireRecord(FireRecord fireRecord){
        return fireRecordMapper.insertSelective(fireRecord);
    }

    public Integer deleteFireRecordById(Integer id){
        return fireRecordMapper.deleteByPrimaryKey(id);
    }

    public Integer updateFireRecordById(FireRecord fireRecord){ return fireRecordMapper.updateByPrimaryKeySelective(fireRecord); }

    public Integer addFireRecordList(List<FireRecord> list){
        int successCount = 0;
        for(FireRecord fr : list){
            successCount += addFireRecord(fr);
        }
        return successCount;
    }
}
