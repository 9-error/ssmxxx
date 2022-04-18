package com.zz.admin.service;

import com.zz.admin.bean.Stu;
import com.zz.admin.mapper.StuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuService {

    @Autowired
    StuMapper stuMapper;

    public Stu getStuById(Long id){
       return stuMapper.getStu(id);
    }

}
