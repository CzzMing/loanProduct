package com.buba.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buba.mapper.LoanMapper;
import com.buba.pojo.Loan;
import com.buba.service.IProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends ServiceImpl<LoanMapper, Loan> implements IProductService {

}
