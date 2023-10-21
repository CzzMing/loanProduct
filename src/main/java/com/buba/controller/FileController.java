package com.buba.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.buba.mapper.DictMapper;
import com.buba.pojo.Dict;
import com.buba.pojo.FileDto;
import com.buba.pojo.FileL;
import com.buba.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/upload")
public class FileController extends ApiController {
    @Autowired
    private IFileService iFileService;
    @Resource
    private DictMapper dictMapper;

    @Value("${file.path}")
    private String path;
    @Value("${file.url}")
    private String url;
    @RequestMapping("/uploadFile")
    public R<Object> save(@RequestParam("file") MultipartFile file){

        String orginFileName =
                file.getOriginalFilename();
        String suffix = orginFileName
                .substring(orginFileName.lastIndexOf("."));
        String newFileName = UUID.randomUUID()+suffix;
        long fileSize = file.getSize();
        String contentType= file.getContentType();
        File newFile = new File( path+newFileName);
        try {
            //把文件上传到指定的位置
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileL fileL = new FileL();
        fileL.setFileName(orginFileName);
        fileL.setNewFileName(newFileName);
        fileL.setFilePath(newFileName);
        fileL.setFileSize(fileSize+"");
        fileL.setFileType(suffix);
        fileL.setIsDeleted(0+"");
        fileL.setCreateBy("test");
        fileL.setCreateTime(new Date());
        iFileService.saveFile(fileL);
        System.out.println(url +newFileName);
        HashMap map = new HashMap();
        map.put("name",orginFileName);
        map.put("url",url+newFileName);
        return R.ok(map);
     }
     @RequestMapping("/selectFile")
     public R<Object> selectPage(FileDto fileDto){
         IPage iPage = iFileService.selectFile(fileDto);
         QueryWrapper queryWrapper = new QueryWrapper();
         queryWrapper.eq("dict_type",fileDto.getDictType());
         List<Dict> list= dictMapper.selectList(queryWrapper);
         Map map = new HashMap<>();
         map.put("filePage",iPage);
         map.put("sysDictList",list);
         return R.ok(map);
     }
    public static void main(String[]args){
        String fileName="test.docx";
        int index =fileName.lastIndexOf(".");
        System.out.println(index);
        System.out.println(fileName.substring(index));
    }
}
