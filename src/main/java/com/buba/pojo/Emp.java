package com.buba.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("emp")
public class Emp {
    @TableId(value = "empno",type = IdType.AUTO)
    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private BigDecimal sal;
    private BigDecimal comm;
    private Integer deptno;
    @TableField(exist = false)
    private int tax;
    @TableField(exist = false)
    private int sjsr;
}
