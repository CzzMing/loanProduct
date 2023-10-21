package com.buba.pojo;

import lombok.Data;

@Data
public class FileDto extends FileL{
    private long pageNow;
    private long pageSize;
    private String dictType;

}
