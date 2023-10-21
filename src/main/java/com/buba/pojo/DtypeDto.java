package com.buba.pojo;

import lombok.Data;

@Data
public class DtypeDto extends Dtype{
    private long pageNow;
    private long pageSize;
    private String dictType;

}
