package com.buba.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.buba.pojo.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper{
    @Select("select * from user where username=#{username} and password=#{password}")
    public User getUserByUserName(String phone);

    @Select("select count(1) from sys_user where phone=#{phone}")
    public int checkPhone(String phone);

}
