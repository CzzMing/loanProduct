package com.buba.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.buba.pojo.DeptDto;
import com.buba.pojo.Emp;
import com.buba.pojo.TranDto;

public interface EmpService extends IService<Emp> {
    public IPage empPage(DeptDto deptDto);
    public int empAdd(Emp emp);
    public Emp updById(int empno);
    public int empUpdate(Emp emp);
    public int empDel(int empno);
}
