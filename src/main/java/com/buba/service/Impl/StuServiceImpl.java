package com.buba.service.Impl;

import com.buba.mapper.StuMapper;
import com.buba.pojo.Student;
import com.buba.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StuServiceImpl implements StuService {
    @Resource
    private StuMapper stuMapper;

    public int saveStu(List<Student> studentList){
        return stuMapper.insertStuBatch(studentList);
    }
}
