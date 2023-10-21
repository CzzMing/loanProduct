package com.buba.pojo;

import lombok.Data;

@Data
public class DictDto extends Dict{
    private long pageNow;
    private long pageSize;

}
