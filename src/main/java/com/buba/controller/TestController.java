package com.buba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    RedisTemplate redisTemplate;
    @RequestMapping("/getTestName")
    public void getName(){
        ValueOperations str = redisTemplate.opsForValue();
        str.set("name","存储在Redis");
        System.out.println(str.get("name"));
    }

}
