package com.buba.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.buba.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/miaosha")
public class RedController extends ApiController {
    @Autowired
    private RedisUtil redisUtil;
    @RequestMapping("/qiannqiang")
    public R<Object> miaosha(String prodid,String uid){
        //1、uid和prodid非空判断
        if(StringUtils.isBlank(uid) || StringUtils.isBlank(prodid)){
            return R.failed("请确认用户是否已经登录或者抢购了商品！");
        }
//2、拼接key
//2.1 库存key
        String productKey="sk:"+prodid+":qt";
        redisUtil.set(productKey,1000);
//2.2 秒杀成功用户key
        String userKey="sk:"+prodid+":user";
//3、判断用户是否重复秒杀操作
        boolean flag =redisUtil.checkIsExist(userKey,uid);
        if(flag){
            return R.failed("用户已经抢购");
        }
//5、判断如果商品数量，库存数量小于1，秒杀结束
        Object obj = redisUtil.get(productKey);
        if(obj==null){
            return R.failed("秒杀还没开始！");
        }
        Integer qty =(Integer)obj;
        if(qty<1){
            return R.failed("秒杀已经结束");
        }
        qty =qty-1;
        redisUtil.set(productKey,qty);
        System.out.println("购买用户Id"+uid);
        System.out.println("库存数量"+qty );
        redisUtil.distinctSet(userKey,uid);
        return R.ok("秒杀成功");
    }
}
