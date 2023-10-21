package com.buba.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("file_attachment")
public class FileL {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String fileName;
    private String fileType;
    private String filePath;
    private String fileSize;
    private String newFileName;
    private String relationId;
    private String businessType;
    private String isDeleted;
    private String remark;
    private Date createTime;
    private String createBy;
    private Date updateTime;
    private String updateBy;

}
