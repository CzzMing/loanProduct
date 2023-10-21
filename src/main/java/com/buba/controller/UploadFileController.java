//package com.buba.controller;
///**
// * @author 49466
// * @date 2023/8/3
// */
//
//import com.baomidou.mybatisplus.extension.api.ApiController;
//import com.baomidou.mybatisplus.extension.api.R;
//import com.example.mybatisplusdemo.entity.FileAttachment;
//import com.example.mybatisplusdemo.service.IFileAttachmentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.Date;
//import java.util.UUID;
//
///**
// * *@ClassName UploadFileController
// * *@Description
// * *@Author 49466
// * *@Date 2023/8/38:32
// * *@Version 1.0
// */
//@RestController
//@RequestMapping("/upload")
//public class UploadFileController extends ApiController {
//@Autowired
//private com.example.mybatisplusdemo.service.IFileAttachmentService fileAttachmentService;
//    // 从属性文件中获取值
//    @Value("${file.path}") //获取文件文件配置路径
//    private String path;
//    @Value("${file.url}")//从yml文件里面获取配置的url
//    private String url;
//    @RequestMapping("/uploadFile")
//    public R<Object>uploadFile(@RequestParam("file")
//                                       MultipartFile file){
//
//       //获取文件的名字
//        String orginFileName =
//                file.getOriginalFilename();
//        //上传文件.docx,截取文件的后缀
//        //UUID的是让分布式系统中的所有元素都能有唯一的辨识信息，
//        // 而不需要通过中央控制端来做辨识信息的指定。
//        // 如此一来，每个人都可以创建不与其它人冲突的UUID。
//        // 在这样的情况下，就不需考虑数据库创建时的名称重复问题。
//                String suffix = orginFileName
//                        .substring(orginFileName.lastIndexOf("."));
//                //新文件名字，第一个：就是不覆盖以前上传的文件
//        //     //，第二个是防止中文乱码的问题
//                String newFileName = UUID.randomUUID()+suffix;
//                //获取文件大小
//                long fileSize =file.getSize();
//        //文件是图片，还是excel,还是word文档
//                String contentType =file.getContentType();
//
//        //创建一个文件
//        File newfile = new File(path+newFileName);
//        try {
//            //把文件上传到指定的位置
//            file.transferTo(newfile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        FileAttachment fileAttachment
//                = new FileAttachment();
//        fileAttachment.setFileName(orginFileName);
//        fileAttachment.setNewFileName(newFileName);
//        fileAttachment.setFilePath(newFileName);
//        fileAttachment.setFileSize(fileSize+"");
//        fileAttachment.setFileType(suffix);
//        fileAttachment.setIsDeleted(0+"");
//        fileAttachment.setCreateBy("test");
//        fileAttachment.setCreateTime(new Date());
//        fileAttachmentService.saveFileAttachment(fileAttachment);
//        System.out.println(url +newFileName);
//        return null;
//    }
//    public static void main(String[]args){
//       String fileName="test.docx";
//      int index =fileName.lastIndexOf(".");
//      System.out.println(index);
//      System.out.println(fileName.substring(index));
//    }
//
//}
