package com.buba.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.buba.pojo.Student;

import java.util.List;

public interface StuMapper extends BaseMapper<Student> {
    public int insertStuBatch(List<Student> studentList);
}
