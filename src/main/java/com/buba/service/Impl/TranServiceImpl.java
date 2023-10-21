package com.buba.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buba.mapper.TranMapper;
import com.buba.pojo.Tran;
import com.buba.pojo.TranDto;
import com.buba.service.TranService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TranServiceImpl extends ServiceImpl<TranMapper,Tran> implements TranService {
    @Resource
    private TranMapper tranMapper;

    @Override
    public IPage tranPage(TranDto tranDto) {
        Page page = new Page<>(tranDto.getPageNow(),tranDto.getPageSize());
        QueryWrapper<Tran> w = new QueryWrapper<>();
        List<Tran> list= tranMapper.selectList(w);
        IPage<Tran> iPage = tranMapper.selectPage(page,w);
        Map map = new HashMap<>();
        map.put("filePage",iPage);
        map.put("sysDictList",list);
        return iPage;
    }

    @Override
    public int tranAdd(Tran tran) {
        return tranMapper.insert(tran);
    }

    public Tran updById(int tranId){
        return tranMapper.selectById(tranId);
    }

    @Override
    public int tranUpdate(Tran tran) {
        return tranMapper.updateById(tran);
    }

    @Override
    public int tranDel(int accountId) {
        return tranMapper.deleteById(accountId);
    }
}
