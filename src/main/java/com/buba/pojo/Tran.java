package com.buba.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("tran")
public class Tran {
    @TableId(value = "tran_id",type = IdType.AUTO)
    private Integer tranId;
    private Integer accountId;
    private String tranType;
    private BigDecimal tranAmount;
    private Date tranTime;
}
