//package com.buba.service.Impl;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.buba.mapper.RuleMapper;
//import com.buba.pojo.Rule;
//import com.buba.service.RuleService;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//
//@Service
//public class RuleServiceImpl extends ServiceImpl<RuleMapper, Rule> implements RuleService {
//    @Resource
//    private RuleMapper ruleMapper;
//
//    public Result getRulePage(int pageSize,int pageNow,String gname,String endTime){
//        IPage page = new Page();
//        page.getSize(pageSize);
//        page.getCurrent(pageNow);
//        QueryWrapper<Rule> wrapper = new QueryWrapper<>();
//        page = ruleMapper.selectPage(page,wrapper);
//        return Result.ok(page);
//    }
//    public boolean addRule(Rule rule) {
//
//    }
//    public boolean updRule(Rule rule) {
//
//    }
//    public boolean delRule(Rule rule) {
//
//    }
//}
