package com.buba.pojo;
/**
 * @author 49466
 * @date 2023/7/19
 */

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * *@ClassName LoanProduct
 * *@Description
 * *@Author 49466
 * *@Date 2023/7/198:46
 * *@Version 1.0
 */
@Data
@TableName("loan_product")//tableName就写实体类对应表的名字
public class LoanProduct {
    @TableId(value="id",type= IdType.AUTO)
    private Long id;//主键ID
    @TableField("title")//exist等于false 表示该字段不在数据库,true就表示在数据库里
    private String title;
    private BigDecimal loanQuotaBegin;
    private BigDecimal loanQuotaEnd;
    private Date createTime;
    private String targetRegions;//针对地区
   // @Version
    private int version;
   /* @TableLogic(value = "0"
            ,delval="1")//value=0正常不删除状态*/
    // ，delval表示删除的值
    @TableLogic
    private int isDeleted;
}
