package com.buba.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.buba.pojo.Dict;
import com.buba.pojo.DictDto;

public interface DictService extends IService<Dict> {
    public IPage dictPage(DictDto dictDto,String dictType);

    public int dictAdd(Dict dict);

    public Dict updById(int dictCode);
    public int dictUpdate(Dict dict);

    public String dictDel(Dict dict);

    public String saveDictData(Dict dict);

    public String updDictData(Dict dict);

}
