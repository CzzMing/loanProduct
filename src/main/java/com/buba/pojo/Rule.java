package com.buba.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("guize")
public class Rule {
    @TableId(value = "gid",type = IdType.AUTO)
    private int gid;
    private String gname;
    private String beginTime;
    private String endTime;
    private String onLine;
    private String remark;
    private String ops;
    private Float quan;
}
