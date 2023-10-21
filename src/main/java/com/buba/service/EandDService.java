package com.buba.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.buba.pojo.DeptDto;
import com.buba.pojo.Emp;
import com.buba.pojo.EmpAndDept;
import com.github.yulichang.base.MPJBaseService;

public interface EandDService{
    public IPage<Emp> getEmpPage(QueryWrapper wrapper, IPage<Emp> page);
}

