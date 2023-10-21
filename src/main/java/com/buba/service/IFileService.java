package com.buba.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.buba.pojo.FileDto;
import com.buba.pojo.FileL;

import java.io.File;

public interface IFileService {
    public int saveFile(FileL file);

    public IPage<FileL> selectFile(FileDto fileDto);

}
