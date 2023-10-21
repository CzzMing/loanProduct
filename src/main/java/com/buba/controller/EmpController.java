package com.buba.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.buba.pojo.*;
import com.buba.service.EandDService;
import com.buba.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
@CrossOrigin
public class EmpController {
    @Autowired
    private EmpService empService;
    @Autowired
    private EandDService eandDService;

    @RequestMapping("/selectP")
    public R<Object> empPage(DeptDto deptDto){
        QueryWrapper queryWrapper = new QueryWrapper();
        Page page =new Page<>(deptDto.getPageNow(),deptDto.getPageSize());
        IPage<Emp> iPage = eandDService.getEmpPage(queryWrapper, page);
        return R.ok(iPage);
    }

    @RequestMapping("/add")
    public R<Object> add(@RequestBody Emp emp){
        int res = empService.empAdd(emp);
        if (res>0){
            return R.ok("成功");
        }else {
            return R.ok("失败");
        }
    }

    @RequestMapping("/selectId/")
    public R<Object> selectId(int empno){
        Emp emp = empService.updById(empno);
        return R.ok(emp);
    }

    @RequestMapping("/update")
    public R<Object> update(@RequestBody Emp emp){
        int res = empService.empUpdate(emp);
        return R.ok("成功");
    }

    @RequestMapping("/delete")
    public R<Object> delete(int empno){
        int res = empService.empDel(empno);
        return R.ok("成功");
    }
}
