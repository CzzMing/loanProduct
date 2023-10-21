package com.buba.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.buba.mapper.TranAndAccountMapper;
import com.buba.pojo.*;
import com.buba.service.TranAndAccountService;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TranAndAccountServiceImpl extends MPJBaseServiceImpl<TranAndAccountMapper, TranAndAccount> implements TranAndAccountService {
    @Resource
    private TranAndAccountMapper tranAndAccountMapper;

    @Override
    public Page<TranAndAccount> tranAndAccountPage(TranDto tranDto, String accountId) {
        Page<TranAndAccount> page = new Page<>(tranDto.getPageNow(),tranDto.getPageSize());
        MPJLambdaWrapper mpj = new MPJLambdaWrapper<Account>()
                .selectAll(Account.class)// 要查的表中的所有列
                .selectAll(Tran.class)
//                .selectAs(Dict::getDictCode, DictAndDtype::getDictCode)// 出现的 其他表中的列名称
//                .selectAs(Dict::getDictLabel, DictAndDtype::getDictLabel)
//                .selectAs(Dict::getDictValue, DictAndDtype::getDictValue)
//                .selectAs(Dict::getDictSort, DictAndDtype::getDictSort)
//                .selectAs(Dict::getStatus, DictAndDtype::getStatus)
//                .selectAs(Dict::getRemark, DictAndDtype::getRemark)
                .leftJoin(Tran.class, Tran::getAccountId,Account::getAccountId);
        return  tranAndAccountMapper.selectPage(page, mpj);
    }
}
