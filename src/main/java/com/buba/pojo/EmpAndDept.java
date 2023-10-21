package com.buba.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("dept")
public class EmpAndDept {
    @TableId(value = "deptno",type = IdType.AUTO)
    private Integer deptno;
    private String dname;
    private String loc;

    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private BigDecimal sal;
    private BigDecimal comm;
}
