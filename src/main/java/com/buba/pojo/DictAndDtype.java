package com.buba.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("sys_dict_type")
public class DictAndDtype {
    @TableId(value = "dictId",type = IdType.AUTO)
    private Integer dictId;
    private String dictName;
    private String dictType;
    private String status;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
    private String remark;

    private Integer dictCode;
    private String dictSort;
    private String dictLabel;
    private String dictValue;
    private String cssClass;
    private String listClass;
    private String isDefault;
}
