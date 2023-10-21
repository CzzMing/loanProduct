package com.buba.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.buba.pojo.DictAndDtype;
import com.buba.pojo.DictAndtypeDto;
import com.github.yulichang.base.MPJBaseService;

public interface DictAndTypeService extends MPJBaseService<DictAndDtype> {
    public IPage pageEmpAndDept(DictAndtypeDto dictAndtypeDto, String dictType);
}
