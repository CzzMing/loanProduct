package com.buba.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buba.mapper.FileMapper;
import com.buba.pojo.FileDto;
import com.buba.pojo.FileL;
import com.buba.service.IFileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

@Service
public class FileServiceImpl implements IFileService {
    @Resource
    private FileMapper fileMapper;

    public int saveFile(FileL file){
        return fileMapper.insert(file);
    }

    @Override
    public IPage<FileL> selectFile(FileDto fileDto) {
        Page page = new Page(fileDto.getPageNow(),fileDto.getPageSize());
        QueryWrapper<FileL> w = new QueryWrapper();
        w.orderByDesc("create_time");
        IPage<FileL> iPage = fileMapper.selectPage(page,w);
        return iPage;
    }
}
