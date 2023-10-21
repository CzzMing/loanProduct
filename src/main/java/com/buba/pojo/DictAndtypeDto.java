package com.buba.pojo;

import lombok.Data;

@Data
public class DictAndtypeDto extends DictAndDtype{
    private long pageNow;
    private long pageSize;
    private String dictType;

}
