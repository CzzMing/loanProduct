package com.buba.controller;

import cn.hutool.jwt.JWTUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.buba.pojo.User;
import com.buba.pojo.UserDto;
import com.buba.service.UserService;
import com.buba.utils.JwtTokenUtils;
import com.buba.utils.RedisConfig;
import com.buba.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/user")
public class UserController extends ApiController {
    @Autowired
    private UserService userService;

    @Autowired(required = false)
    private RedisUtils redisUtils;
    @RequestMapping("/login")
    public R<Object> login(@RequestBody User user){

        Object smsObj = redisUtils.get("login:"+user.getPhone());
        if (smsObj!=null && user.getEmail()!=null
                &&!"".equals((user.getSmsCode())
                &&!"undefinde".equals(user.getSmsCode()))){
            String email = (String) smsObj;
            if (email.equals(user.getEmail())){
                User user1 = userService.getUserByuserName(user.getPhone());
                if (user!=null){
                    String token = JwtTokenUtils.createJWT(user.getUserId()+"", (long) (7*24*60*60*1000));
                    redisUtils.set(user.getUserId()+"",user1);
                    Map<String,Object> map = new HashMap<String,Object>();
                    map.put("token",token);
                    user.setPassword("");
                    map.put("user1",user1);
                    return R.ok(map);
                }
            }
        }
        return R.ok("请重新发送验证码！");
    }
//    @RequestMapping("/loginBySms")
//    public R<Object>loginBySms(@RequestBody SysUser sysUser){
//        Object smsObj = redisUtil.get("login:"+sysUser.getPhone());
//        if(smsObj!=null &&  sysUser.getSmsCode()!=null
//                &&!"".equals( sysUser.getSmsCode())
//                &&!"undefined".equals(sysUser.getSmsCode())){
//            String smsCode =(String)smsObj;
//            if(smsCode.equals(sysUser.getSmsCode())){
//                SysUser user= sysUserService.getUserBySms(sysUser.getPhone());
//                if(user!=null){
//                    String token= JwtUtils
//                            .createJWT(user.getId()+"",7*24*60*60*1000);
//                    redisUtil.set(user.getId()+"",user);
//                    Map<String,Object> map = new HashMap<String,Object>();
//                    map.put("token",token);
//                    user.setPassword("");
//                    map.put("user",user);
//                    return R.ok(map);
//
//                }
//            }
//
//        }
//        return R.ok("请重新发送验证码！");
//    }

    @RequestMapping("/phone")
    public R<Object> phone(String phone){
        boolean flag = userService.checkPhone(phone);
        if (flag){
            Random random= new Random();
            int randomNumber = random.nextInt(1000000);
            String formattedNumber = String.format("%86d",randomNumber);
            redisUtils.set("login:"+phone,formattedNumber);
            return R.ok("验证码是："+formattedNumber);
        }else {
            return R.ok("用户不存在");
        }
    }
}
