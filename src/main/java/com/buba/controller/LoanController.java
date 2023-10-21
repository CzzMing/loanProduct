package com.buba.controller;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.buba.pojo.Loan;
import com.buba.pojo.LoanDto;
import com.buba.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/loan")
@CrossOrigin
public class LoanController extends ApiController {
    @Autowired
    private LoanService loanService;

    @RequestMapping("/empList")
    public List<Loan> empList() {
        return loanService.loanList();
    }

//    @RequestMapping("/deptList")
//    public List<EmpAndDeptDTO> deptList() {
//        return emp.getEmpAndDept();
//    }

    @RequestMapping("/addEmp")
    public R<String> addEmp(@RequestBody Loan loan){
        loanService.saveOrUpdate(loan);
        return R.ok("保存成功");
    }
    @RequestMapping("/updateEmp")
    public boolean updateEmp(@RequestBody Loan loan){
        return loanService.updateLoan(loan);
    }
    @RequestMapping("/delEmp")
    public int delEmp(Integer id) {
        return loanService.delLoan(id);
    }
    //    @RequestMapping("/empPage")
//    public Page<Emp> empPage(@RequestBody JSONObject json) {
//        Integer pageNow = json.getInt("pageNow");
//        Integer pageSize = json.getInt("pageSize");
//        String ename = json.getStr("ename");
//        return empService.empPage(pageNow,pageSize,ename);
//    }
    @RequestMapping("/empPage")
    public Page<Loan> empPage(@RequestBody JSONObject json) {
        Integer pageNow = json.getInt("pageNow");
        Integer pageSize = json.getInt("pageSize");
        String title = json.getStr("title");
        return loanService.loanPage(pageNow,pageSize,title);
    }
    @RequestMapping("/loanPage")
      public IPage<Loan> loanPage(LoanDto loanDto){
        return loanService.loanIPage(loanDto);
    }
}
