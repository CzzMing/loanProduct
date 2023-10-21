package com.buba.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.buba.pojo.TranAndAccount;
import com.buba.pojo.TranDto;
import com.github.yulichang.base.MPJBaseService;

public interface TranAndAccountService extends MPJBaseService<TranAndAccount> {
    public IPage tranAndAccountPage(TranDto tranDto, String accountId);
}
