package com.buba.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buba.mapper.DtypeMapper;
import com.buba.pojo.Dict;
import com.buba.pojo.Dtype;
import com.buba.pojo.DtypeDto;
import com.buba.service.DtypeService;
import com.buba.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DtypeServiceImpl extends ServiceImpl<DtypeMapper, Dtype> implements DtypeService {
    @Resource
    private DtypeMapper dtypeMapper;
    @Autowired
    private RedisUtils redisUtils;

    public IPage dtypePage(DtypeDto dtypeDto,String dictType){
        Page page = new Page(dtypeDto.getPageNow(),dtypeDto.getPageSize());
        QueryWrapper<Dtype> w = new QueryWrapper();
//        w.like("dict_type",dictType);
        IPage<Dtype> iPage = dtypeMapper.selectPage(page,w);
        return iPage;
    }

    public int typeAdd(Dtype dtype){
        return dtypeMapper.insert(dtype);
    }

    public Dtype upById(int dictId) {
        return dtypeMapper.selectById(dictId);
    }

    public int typeUpd(Dtype dtype){
        return dtypeMapper.updateById(dtype);
    }

    public int typeDel(int dictId){
        return dtypeMapper.deleteById(dictId);
    }

    @Override
    public List<Dict> dictType(String dictType) {
        Object obj = redisUtils.get(dictType);
        List<Dict> list = null;
        if (obj==null){
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("dict_type",dictType);
            queryWrapper.eq("status",0);

            list = dtypeMapper.selectList(queryWrapper);
        }else {
            list = (List<Dict>) obj;
        }
        return list;
    }

}
