package com.buba.controller;
/**
 * @author 49466
 * @date 2023/8/30
 */

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.buba.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

/**
 * 秒杀
 * *@ClassName MiaoShaController
 * *@Description
 * *@Author 49466
 * *@Date 2023/8/3014:06
 * *@Version 1.0
 */
@RestController
@RequestMapping("/miaosha")
public class MiaoShaController extends ApiController {

    @Autowired
    private RedisUtil redisUtil;
   /* public MiaoShaController(HttpServletRequest request){
        if (redisUtil == null) {
            //原因：拦截器在SpringContext初始化之前就执行了，Bean初始化之前它就执行了，所以它肯定是无法获取SpringIOC容器中的内容的。
            WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
            redisUtil = wac.getBean(RedisUtil.class);
        }
        String productKey="sk:1:qt";
        redisUtil.set(productKey,1000);
    }*/
    @RequestMapping("/qiannnqiang")
    public R<Object>qianggou(){
        for(int i=0 ;i<2;i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("当前线程"+Thread.currentThread().getName());
                    miaosha("1", finalI +"");
                }
            }).start();
        }
        return R.ok("秒杀结束");
    }
   // @RequestMapping("/qiannnqiang")
    public R<Object> miaosha(String prodid, String uid){
//1、uid和prodid非空判断
        if(StringUtils.isBlank(uid) || StringUtils.isBlank(prodid)){
            return R.failed("请确认用户是否已经登录或者抢购了商品！");
        }
//2、拼接key
//2.1 库存key
        String productKey="sk:"+prodid+":qt";

//2.2 秒杀成功用户key
        String userKey="sk:"+prodid+":user";
//3、判断用户是否重复秒杀操作
    boolean flag =redisUtil.checkIsExist(userKey,uid);
    if(flag){
        return R.failed("用户已经抢购");
    }
   // synchronized (this) {//只适合单台tomcat
//5、判断如果商品数量，库存数量小于1，秒杀结束
        String lockKey="key:"+prodid;
        String uuid = UUID.randomUUID().toString()
                .replaceAll("-","");
       boolean lockflag= redisUtil.setNx(lockKey,uuid);//加锁
        redisUtil.expireTimeSecond(lockKey,1);
        if(!lockflag){
            return R.failed("请用户重试");
        }
        Object obj = redisUtil.get(productKey);
        if (obj == null) {
            return R.failed("秒杀还没开始！");
        }
        Integer qty = (Integer) obj;
        if (qty <1) {
            return R.failed("秒杀已经结束");
        }
//6、秒杀过程
//6.1、库存-1

        System.out.println("购买用户Id===========" + uid);
        System.out.println("库存数量===========" + qty);
        qty = qty - 1;
        redisUtil.set(productKey, qty);

//6.2 把秒杀成功用户添加清单里面
        redisUtil.distinctSet(userKey, uid);
        Object value = redisUtil.get(lockKey);
        if(value!=null && value.equals(uuid)) {//只能释放自己的锁
            redisUtil.del(lockKey);
        }
 // }
        return R.ok("恭喜你，秒杀成功！");
    }

}
