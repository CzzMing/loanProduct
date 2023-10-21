package com.buba.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.buba.pojo.Dict;
import com.buba.pojo.DictAndtypeDto;
import com.buba.pojo.Dtype;
import com.buba.pojo.DtypeDto;
import com.buba.service.DictAndTypeService;
import com.buba.service.DtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dtype")
@CrossOrigin
public class DtypeController extends ApiController {
    @Autowired
    private DtypeService dtypeService;
    @Autowired
    private DictAndTypeService dictAndTypeService;

    @RequestMapping("/selectPage")
    public R<Object> selectPage(DtypeDto dtypeDto,String dictType){
        IPage<Dtype> iPage = dtypeService.dtypePage(dtypeDto,dictType);
        return R.ok(iPage);
    }
    @RequestMapping("/dictList")
    public R<Object> dictList(String dictType){
        List<Dict> message = dtypeService.dictType(dictType);
        return R.ok(message);
    }
    @RequestMapping("/add")
    public R<Object> add(@RequestBody Dtype dtype){
        int res = dtypeService.typeAdd(dtype);
        if (res>0){
            return R.ok("成功");
        }else{
            return R.ok("失败");
        }
    }

    @RequestMapping("/selectId")
    public R<Object> selectId(int dictId){
        Dtype dtype = dtypeService.upById(dictId);
        return R.ok(dtype);
    }

    @RequestMapping("/update")
    public R<Object> update(@RequestBody Dtype dtype){
        int res = dtypeService.typeUpd(dtype);
        if (res>0){
            return R.ok("成功");
        }else {
            return R.ok("失败");
        }
    }

    @RequestMapping("/delete")
    public R<Object> delete(int dictId){
        int res = dtypeService.typeDel(dictId);
        return R.ok("成功");
    }


}
