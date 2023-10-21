package com.buba.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.buba.pojo.Dict;
import com.buba.pojo.Dtype;
import com.buba.pojo.DtypeDto;

import java.util.List;

public interface DtypeService extends IService<Dtype> {
    public IPage dtypePage(DtypeDto dtypeDto,String dictType);
    public int typeAdd(Dtype dtype);
    public Dtype upById(int dictId);
    public int typeUpd(Dtype dtype);
    public int typeDel(int dictId);

    public List<Dict> dictType(String dictType);


}
