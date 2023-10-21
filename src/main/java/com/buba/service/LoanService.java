package com.buba.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.buba.pojo.Loan;
import com.buba.pojo.LoanDto;

import java.util.List;

public interface LoanService extends IService<Loan> {
    public int addLoan(Loan loan);
    public int delLoan(Integer id);
    public boolean updateLoan(Loan loan);
    public List<Loan> loanList();
    public Page<Loan> loanPage(Integer pageNow, Integer pageSize, String title);
    public IPage<Loan> loanIPage(LoanDto loanDto);

}
