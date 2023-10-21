package com.buba.controller;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.buba.pojo.Dict;
import com.buba.pojo.DictAndDtype;
import com.buba.pojo.DictAndtypeDto;
import com.buba.pojo.DictDto;
import com.buba.service.DictAndTypeService;
import com.buba.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dict")
@CrossOrigin
public class DictController extends ApiController {
    @Autowired
    private DictService dictService;
    @Autowired
    private DictAndTypeService dictAndTypeService;

    @RequestMapping("/selectPage")
    public R<Object> selectPage(DictDto dictDto,String dictType){
        IPage<Dict> iPage = dictService.dictPage(dictDto,dictType);
        return R.ok(iPage);
    }

    @RequestMapping("/typePage")
    public R<Object> dypePage(DictAndtypeDto dictAndtypeDto, String dictType){
        IPage<Dict> iPage = dictAndTypeService.pageEmpAndDept(dictAndtypeDto,dictType);
        return R.ok(iPage);
    }

    @RequestMapping("/add")
    public R<Object> add(@RequestBody Dict dict){
        int res = dictService.dictAdd(dict);
        if (res>0){
            return R.ok("成功");
        }else {
            return R.ok("失败");
        }
    }

    @RequestMapping("/selectId/")
    public R<Object> selectId(int dictCode){
        Dict dict = dictService.updById(dictCode);
        return R.ok(dict);
    }

    @RequestMapping("/update")
    public R<Object> update(@RequestBody Dict dict){
        int res = dictService.dictUpdate(dict);
        return R.ok("成功");
    }

    @RequestMapping("/delete")
    public R<Object> delete(@RequestBody Dict dict){
        String message = dictService.dictDel(dict);
        return R.ok(message);
    }

    @RequestMapping("/dictPage")
    public R<Object> dictPage(DictAndtypeDto dictAndtypeDto,String dictType) {
        IPage<DictAndDtype> iPage = dictAndTypeService.pageEmpAndDept(dictAndtypeDto,dictType);
        return R.ok(iPage);
    }
    @RequestMapping("/dictData")
    public R<Object> dictData(@RequestBody Dict dict){
        String message = dictService.saveDictData(dict);
        return R.ok(message);
    }
    @RequestMapping("/upddictData")
    public R<Object> upddictData(@RequestBody Dict dict){
        String message = dictService.updDictData(dict);
        return R.ok(message);
    }
}
