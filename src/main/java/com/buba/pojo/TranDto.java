package com.buba.pojo;

import lombok.Data;

@Data
public class TranDto extends TranAndAccount{
    private long pageNow;
    private long pageSize;

}
