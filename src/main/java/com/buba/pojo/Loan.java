package com.buba.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("loan")
public class Loan {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String title;
    private BigDecimal loanQuotaBegin;
    private BigDecimal loanQuotaEnd;
    private String loanRateType;
    private String rateBegin;
    private String rateEnd;
    private String repaymentDeadlineBegin;
    private String repaymentDeadlineEnd;
    private Integer loanTerm;
    private String loanMethod;
    private String targetRegions;
    private String targetAudience;
    private String createTime;
    private String createBy;
    private String updateTime;
    private String updateBy;
    @Version
    private int version;
    @TableLogic
    private int isDeleted;
}
