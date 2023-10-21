package com.buba.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buba.mapper.LoanMapper;
import com.buba.pojo.Loan;
import com.buba.pojo.LoanDto;
import com.buba.service.LoanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoanServiceImpl extends ServiceImpl<LoanMapper, Loan> implements LoanService {
    @Resource
    private LoanMapper loanMapper;
    @Override
    public int addLoan(Loan loan) {
        return loanMapper.insert(loan);
    }

    @Override
    public int delLoan(Integer id) {
        return loanMapper.deleteById(id);
    }

    @Override
    public boolean updateLoan(Loan loan) {
        return updateById(loan);
    }

    @Override
    public List<Loan> loanList() {
        return query().list();
    }

    @Override
    public Page<Loan> loanPage(Integer pageNow, Integer pageSize, String title) {
        Page<Loan> page = new Page<>(pageNow, pageSize);
        QueryWrapper w = new QueryWrapper<>();
        w.like("title", title);
        loanMapper.selectPage(page, w);
        return page;
    }
    public IPage<Loan> loanIPage(LoanDto loanDto){
        Page page = new Page(loanDto.getPageNow(),loanDto.getPageSize());
        QueryWrapper w = new QueryWrapper<>();

//        if (loanDto != null
//                && loanDto.getId() != null
//                && !"".equals(loanDto.getId())
//        ) {
//            w.eq("id",loanDto.getId());
//        }
//        if (loanDto != null
//                && loanDto.getTitle() != null
//                && !"".equals(loanDto.getTitle())
//        ) {
//            w.like("title",loanDto.getTitle());
//        }
//        w.orderByDesc("create_time");
        LambdaQueryWrapper<Loan> lw = new LambdaQueryWrapper<>();
        lw.like(Loan::getTitle,loanDto.getTitle());
        lw.orderByDesc(Loan::getCreateTime);
        IPage<Loan> loanPage = loanMapper.selectPage(page,w);
        return loanPage;
    }
}
