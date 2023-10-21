package com.buba.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("account")
public class Account {
    @TableId(value = "account_id",type = IdType.AUTO)
    private Integer accountId;
    private String name;
    private String type;
    private BigDecimal balance;
}
