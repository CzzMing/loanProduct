package com.buba.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.buba.pojo.User;
import com.buba.pojo.UserDto;

public interface UserService{
    User getUserByuserName(String phone);

    public boolean checkPhone(String phone);
}
