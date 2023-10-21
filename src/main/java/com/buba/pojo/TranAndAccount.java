package com.buba.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("account")
public class TranAndAccount {
    @TableId(value = "account_id", type = IdType.AUTO)
    private Integer accountId;
    private String name;
    private String type;
    private BigDecimal balance;

    private Integer tranId;
    private String tranType;
    private BigDecimal tranAmount;
    private Date tranTime;


}
