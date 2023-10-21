//package com.buba.service.Impl;
//
//import cn.hutool.core.util.StrUtil;
//import cn.hutool.json.JSONUtil;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.buba.mapper.GuiZeMapper;
//import com.buba.pojo.Emp;
//import com.buba.pojo.GuiZe;
//import com.buba.service.IGuiZeService;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.concurrent.TimeUnit;
//
//@Service
//public class GuiZeServiceImpl
//        extends ServiceImpl<GuiZeMapper, GuiZe>
//        implements IGuiZeService {
//
//    @Resource
//    private GuiZeMapper guiZeMapper;
//
//    @Resource
//    private StringRedisTemplate stringRedisTemplate;
//
//    /**
//     * 规则数据列表 分页 模糊查询
//     * @param pageNow 当前页
//     * @param pageSize 每页显示记录数
//     * @param gname 规则名称
//     * @param endTime 结束时间
//     * @return
//     */
//    public Result getGuiZePage
//            (int pageNow, int pageSize, String gname, String endTime){
//        //1、 数据列表
//        // todo 2、在数据列表基础上，添加分页 和模糊查询
//        IPage page = new Page();
//
//        // todo 每页记录数
//        page.setSize(pageSize);
//
//        // todo 当前页
//        page.setCurrent(pageNow);
//
//        QueryWrapper<GuiZe> q = new QueryWrapper<>();
//        //if(gname!=null && !gname.equals(""))
//
//        // todo 当 规则名称不为空 成为查询条件
//        if(StrUtil.isNotBlank(gname)){
//            q.eq("gname", gname);
//        }
//
//        // todo 当 结束时间 不为空 成为查询条件
//        if(StrUtil.isNotBlank(endTime)){
//            q.between("end_time",
//                    "2022-01-01 00:00:00",
//                    endTime);
//        }
//
//        // todo 发出查询操作
//        page = guiZeMapper.selectPage(page, q);
//        // todo 3、给返回值
//        return Result.ok(page);
//    }
//
//    public Result addGuiZe(GuiZe guiZe){
//        try {
//            // todo 1、 存入数据库
//            guiZeMapper.insert(guiZe);
//
//            //todo 将刚刚存入到 数据库中的数据，再查出来
//            QueryWrapper<GuiZe> q = new QueryWrapper<>();
//            // 查询数据列表，以gid 降序排列
//            q.orderByDesc("gid");
//            guiZe = list(q).get(0);
//
//            // todo 将实体类数据，转换为json 数据
//            String json = JSONUtil.toJsonStr(guiZe);
//
//            // todo 2、 存入缓存
//            stringRedisTemplate.opsForValue()
//                    .set("cache:guize:id:"+guiZe.getGid(),
//                        json, 20L, TimeUnit.MINUTES);
//            return Result.ok();
//        }catch (Exception e){
//            e.printStackTrace();
//            return Result.fail("新增操作，操作失败，请检查操作步骤!!!");
//        }
//    }
//
//    @Override
//    public Emp updById(int empno) {
//        return null;
//    }
//
//    @Override
//    public int empUpdate(Emp emp) {
//        return 0;
//    }
//
//    /*public boolean addGuiZe(GuiZe guiZe){
//        try {
//            return true;
//        }catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }*/
//
//    public Result delGuiZe(int gid){
//        try {
//            // todo 删数据库的
//            removeById(gid);
//            // todo 删缓存的
//            stringRedisTemplate.delete("cache:guize:id:"+gid);
//            return Result.ok();
//        }catch (Exception e){
//            e.printStackTrace();
//            return Result.fail("删除操作，操作失败，请检查操作步骤!!!");
//        }
//    }
//
//    public Result updateGuiZe(GuiZe guiZe){
//        try {
//            // todo 更新数据库的数据
//            updateById(guiZe);
//            // todo 更新缓存的
//            // todo 将实体类数据，转换为json 数据
//            String json = JSONUtil.toJsonStr(guiZe);
//
//            // todo 2、 存入缓存
//            stringRedisTemplate.opsForValue()
//                    .set("cache:guize:id:"+guiZe.getGid(),
//                            json, 20L, TimeUnit.MINUTES);
//
//            return Result.ok();
//        }catch (Exception e){
//            e.printStackTrace();
//            return Result.fail("修改操作，操作失败，请检查操作步骤!!!");
//        }
//    }
//
//}
