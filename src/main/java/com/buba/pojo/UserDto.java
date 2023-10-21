package com.buba.pojo;

import lombok.Data;

@Data
public class UserDto extends User{
    private long pageNow;
    private long pageSize;
}
