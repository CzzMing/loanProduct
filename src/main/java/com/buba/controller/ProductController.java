//package com.buba.controller;
///**
// * @author 49466
// * @date 2023/7/19
// */
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//
//import com.baomidou.mybatisplus.extension.api.ApiController;
//import com.baomidou.mybatisplus.extension.api.R;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.buba.mapper.LoanMapper;
//import com.buba.pojo.LoanProduct;
//import com.buba.service.IApplyProducService;
//import com.buba.service.IProductService;
//import com.buba.utils.RedisUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Iterator;
//import java.util.Set;
//
///**
// * *@ClassName ProductController
// * *@Description
// * *@Author 49466
// * *@Date 2023/7/198:57
// * *@Version 1.0
// */
//@RestController
//@RequestMapping("/product")
//public class ProductController extends ApiController {
//    @Autowired
//    private LoanMapper loanMapper;
//    @Autowired
//    private IProductService productService;
//    @Autowired
//    private IApplyProducService applyProductService;
//    @Autowired
//    private RedisUtil redisUtil;
//    @RequestMapping("/save")
//    public R<String> insert(@RequestBody LoanProduct loanProduct){
//     //   loanProductMapper.insert(loanProduct);
//        productService.saveOrUpdate(loanProduct);
//        return R.ok("保存成功");
//    }
//    @RequestMapping("/getTopFiveProduct")
//    public R<Object>getTopFiveProduct(){
//        Set set =redisUtil.zget("topFiveLoanProduct",0,4);
//        if(set==null||set.size()<=0){
//            set = applyProductService.selectHotProduct();
//        }
//       return R.ok(set);
//    }
//    @RequestMapping("/selectById")
//    public R<LoanProduct> selectById(String id){
//       LoanProduct loanProduct= loanProductMapper.selectById(id);
//        return R.ok(loanProduct);
//    }
//
//    @RequestMapping("/updateProduct")
//    public R<String> updateProduct(@RequestBody LoanProduct loanProduct){
//       loanProductMapper.updateById(loanProduct);
//        return R.ok("修改成功");
//    }
//
//    /**
//     * 分页
//     * @param loanProductDto
//     * @return
//     */
//    @RequestMapping("/selectPage")
//    public R<IPage<LoanProduct>>selectPage(LoanProductDto loanProductDto){
//        Page page= new Page(loanProductDto.getPageNum()
//                ,loanProductDto.getPageSize());//第一个参数是当前第几页
//        // ，第二个参数是每页的条数
//        /*QueryWrapper queryWrapper = new QueryWrapper();
//        if(loanProductDto!=null
//                && loanProductDto.getId()!=null
//                &&! "".equals(loanProductDto.getId())) {
//            queryWrapper.eq("id", loanProductDto.getId());
//        }
//        if(loanProductDto!=null
//                && loanProductDto.getTitle()!=null
//                &&! "".equals(loanProductDto.getTitle())) {
//            queryWrapper.like("title",
//                    loanProductDto.getTitle());
//        }
//        queryWrapper.orderByDesc("create_time");*/
//      LambdaQueryWrapper<LoanProduct> lambdaQueryWrapper
//              = new LambdaQueryWrapper();
//        if(loanProductDto!=null
//                && loanProductDto.getTitle()!=null
//                &&! "".equals(loanProductDto.getTitle())) {
//            lambdaQueryWrapper.like(LoanProduct::getTitle
//                    , loanProductDto.getTitle());
//        }
//        lambdaQueryWrapper.orderByDesc(LoanProduct::getCreateTime);
//        IPage<LoanProduct>loanProductPage =
//                loanProductMapper.selectPage(page
//                        ,lambdaQueryWrapper);
//        return R.ok(loanProductPage);
//    }
//    @RequestMapping("/deleteById")
//    public R<String> deleteById(String id){
//        int res =
//                loanProductMapper
//                        .deleteById(id);
//        if(res>0) {
//            return R.ok("删除成功");
//        }else {
//            return R.ok("删除失败");
//        }
//    }
//
//}
