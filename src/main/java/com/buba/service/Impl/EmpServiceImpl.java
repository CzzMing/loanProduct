package com.buba.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buba.mapper.EmpMapper;
import com.buba.pojo.DeptDto;
import com.buba.pojo.Emp;
import com.buba.pojo.Tran;
import com.buba.pojo.TranDto;
import com.buba.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements EmpService {
    @Resource
    private EmpMapper empMapper;
    @Override
    public IPage empPage(DeptDto deptDto) {
        Page page = new Page<>(deptDto.getPageNow(),deptDto.getPageSize());
        QueryWrapper<Emp> w = new QueryWrapper<>();
        List<Emp> list= empMapper.selectList(w);
        IPage<Emp> iPage = empMapper.selectPage(page,w);
        Map map = new HashMap<>();
        map.put("filePage",iPage);
        map.put("sysDictList",list);
        return iPage;
    }

    @Override
    public int empAdd(Emp emp) {
        return empMapper.insert(emp);
    }

    @Override
    public Emp updById(int empno) {
        return empMapper.selectById(empno);
    }

    @Override
    public int empUpdate(Emp emp) {
        return empMapper.updateById(emp);
    }

    @Override
    public int empDel(int empno) {
        return empMapper.deleteById(empno);
    }
}
