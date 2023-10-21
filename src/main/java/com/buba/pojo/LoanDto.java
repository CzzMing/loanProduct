package com.buba.pojo;

import lombok.Data;

@Data
public class LoanDto extends Loan{
    private long pageNow;
    private long pageSize;

}
