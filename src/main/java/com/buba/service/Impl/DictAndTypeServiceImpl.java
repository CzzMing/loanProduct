package com.buba.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.buba.mapper.DictAndTypeMapper;
import com.buba.pojo.Dict;
import com.buba.pojo.DictAndDtype;
import com.buba.pojo.DictAndtypeDto;
import com.buba.pojo.Dtype;
import com.buba.service.DictAndTypeService;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DictAndTypeServiceImpl extends MPJBaseServiceImpl<DictAndTypeMapper, DictAndDtype> implements DictAndTypeService {
    @Resource
    private DictAndTypeMapper datMapper;

    @Override
    public Page<DictAndDtype> pageEmpAndDept(DictAndtypeDto dictAndtypeDto,String dictType) {
        Page<DictAndDtype> page = new Page<>(dictAndtypeDto.getPageNow(),dictAndtypeDto.getPageSize());
        MPJLambdaWrapper mpj = new MPJLambdaWrapper<Dtype>()
                .selectAll(Dtype.class)// 要查的表中的所有列
                .selectAll(Dict.class)
//                .selectAs(Dict::getDictCode, DictAndDtype::getDictCode)// 出现的 其他表中的列名称
//                .selectAs(Dict::getDictLabel, DictAndDtype::getDictLabel)
//                .selectAs(Dict::getDictValue, DictAndDtype::getDictValue)
//                .selectAs(Dict::getDictSort, DictAndDtype::getDictSort)
//                .selectAs(Dict::getStatus, DictAndDtype::getStatus)
//                .selectAs(Dict::getRemark, DictAndDtype::getRemark)
                .leftJoin(Dict.class, Dict::getDictType,Dtype::getDictType);
        return  datMapper.selectPage(page, mpj);
    }
}
