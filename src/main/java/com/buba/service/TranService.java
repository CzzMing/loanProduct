package com.buba.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.buba.pojo.Tran;
import com.buba.pojo.TranDto;

public interface TranService extends IService<Tran> {
    public IPage tranPage(TranDto tranDto);
    public int tranAdd(Tran tran);
    public Tran updById(int tranId);
    public int tranUpdate(Tran tran);
    public int tranDel(int accountId);
}
