package com.buba.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.buba.mapper.EmpAndDeptMapper;
import com.buba.pojo.*;
import com.buba.service.EandDService;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EandDServiceImpl extends MPJBaseServiceImpl<EmpAndDeptMapper, EmpAndDept> implements EandDService {
    @Resource
    private EmpAndDeptMapper empAndDeptMapper;

    public IPage<Emp> getEmpPage(QueryWrapper wrapper, IPage<Emp> page) {
        return empAndDeptMapper.getEmpPage(wrapper,page);
    }
//    public Page<EmpAndDept> empAndDeptPage(DeptDto deptDto, Integer deptno) {
//        Page<EmpAndDept> page = new Page<>(deptDto.getPageNow(),deptDto.getPageSize());
//        MPJLambdaWrapper mpj = new MPJLambdaWrapper<Emp>()
//                .selectAll(Emp.class)// 要查的表中的所有列
//                .selectAll(Dept.class)
////                .selectAs(Dict::getDictCode, DictAndDtype::getDictCode)// 出现的 其他表中的列名称
////                .selectAs(Dict::getDictLabel, DictAndDtype::getDictLabel)
////                .selectAs(Dict::getDictValue, DictAndDtype::getDictValue)
////                .selectAs(Dict::getDictSort, DictAndDtype::getDictSort)
////                .selectAs(Dict::getStatus, DictAndDtype::getStatus)
////                .selectAs(Dict::getRemark, DictAndDtype::getRemark)
//                .leftJoin(Emp.class, Emp::getDeptno,Dept::getDeptno);
//        return  empAndDeptMapper.selectPage(page, mpj);
//    }
}
