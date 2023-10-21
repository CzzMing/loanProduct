package com.buba.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buba.mapper.UserMapper;
import com.buba.pojo.User;
import com.buba.pojo.UserDto;
import com.buba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserByuserName(String phone) {
        return userMapper.getUserByUserName(phone);
    }
    public boolean checkPhone(String phone){
        int count = userMapper.checkPhone(phone);
        if (count>0){
            return true;
        }else {
            return false;
        }
    }
}
