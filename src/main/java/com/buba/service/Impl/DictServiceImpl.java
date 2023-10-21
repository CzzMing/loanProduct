package com.buba.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buba.mapper.DictMapper;
import com.buba.pojo.Dict;
import com.buba.pojo.DictDto;
import com.buba.service.DictService;
import com.buba.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {
    @Resource
    private DictMapper dictMapper;
    @Autowired
    private RedisUtils redisUtils;

    public IPage dictPage(DictDto dictDto,String dictType) {
        Page page = new Page<>(dictDto.getPageNow(),dictDto.getPageSize());
        QueryWrapper<Dict> w = new QueryWrapper<>();
        w.like("dict_type",dictType);
        List<Dict> list= dictMapper.selectList(w);
        IPage<Dict> iPage = dictMapper.selectPage(page,w);
        Map map = new HashMap<>();
        map.put("filePage",iPage);
        map.put("sysDictList",list);
        return iPage;
    }

    public int dictAdd(Dict dict){
        return dictMapper.insert(dict);
    }

    public Dict updById(int dictCode){
        return dictMapper.selectById(dictCode);
    }
    public int dictUpdate(Dict dict){
        return dictMapper.updateById(dict);
    }

    public String dictDel(Dict dict) {
       dictMapper.deleteById(dict.getDictCode());
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("dict_type",dict.getDictType());
        queryWrapper.eq("status",0);
        List<Dict>sysDictDataList= dictMapper.selectList(queryWrapper);
        redisUtils.del(dict.getDictType());
        redisUtils.set(dict.getDictType(),sysDictDataList);
        return "删除成功";
    }

    public  String saveDictData(Dict dict){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("dict_type",dict.getDictType());
        queryWrapper.eq("status",0);
        queryWrapper.eq("dict_value",dict.getDictValue());
        List<Dict>list= dictMapper.selectList(queryWrapper);
        String message="";
        if(list.size()<=0) {
            int res =dictMapper.insert(dict);
            queryWrapper = new QueryWrapper();
            queryWrapper.eq("dict_type",dict.getDictType());
            queryWrapper.eq("status",0);

            List<Dict>sysDictDataList =dictMapper.selectList(queryWrapper);
            redisUtils.del(dict.getDictType());
            redisUtils.set(dict.getDictType(),sysDictDataList);
            if(res>0){
                message="保存成功";
            }else{
                message ="保存失败";
            }
        }else{
            message="已经存在";
        }
        return message;
    }

    @Override
    public String updDictData(Dict dict) {
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("dict_type",dict.getDictType());
            queryWrapper.eq("status",0);
            queryWrapper.eq("dict_value",dict.getDictValue());
            queryWrapper.ne("dict_code",dict.getDictCode());

            //查询当前要修改的字典值不是当前字典编码的值是否存在
            List<Dict>list= dictMapper.selectList(queryWrapper);
            String message="";
            if(list.size()<=0) {
                int res =dictMapper.updateById(dict);
                queryWrapper = new QueryWrapper();
                queryWrapper.eq("dict_type",dict.getDictType());
                queryWrapper.eq("status",0);
                //查询该字典下所有字典明细
                List<Dict>sysDictDataList =dictMapper.selectList(queryWrapper);
                //删除对应字典值里面的键值对
                redisUtils.del(dict.getDictType());
                //保存对应字典所有值
                redisUtils.set(dict.getDictType()
                        ,sysDictDataList);
                if(res>0){
                    message="保存成功";
                }else{
                    message ="保存失败";
                }
            }else{
                message="已经存在";
            }
            return message;
        }

    }
