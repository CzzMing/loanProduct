package com.buba.pojo;

import lombok.Data;

@Data
public class PostDto extends Post{
    private long pageNow;
    private long pageSize;

}
