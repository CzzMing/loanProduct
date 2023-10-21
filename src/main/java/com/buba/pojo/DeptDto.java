package com.buba.pojo;

import lombok.Data;

@Data
public class DeptDto extends EmpAndDept{
    private long pageNow;
    private long pageSize;
}
