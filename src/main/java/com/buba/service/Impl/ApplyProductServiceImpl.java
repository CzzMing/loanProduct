package com.buba.service.Impl;
/**
 * @author 49466
 * @date 2023/8/28
 */

import com.buba.mapper.ApplyProductMapper;
import com.buba.pojo.LoanProductDto;
import com.buba.service.IApplyProducService;
import com.buba.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * *@ClassName ApplyProductServiceImpl
 * *@Description
 * *@Author 49466
 * *@Date 2023/8/2814:25
 * *@Version 1.0
 */
@Service
public class ApplyProductServiceImpl implements IApplyProducService {
    @Resource
    private ApplyProductMapper applyProductMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Set selectHotProduct() {
        List<LoanProductDto>loanProductList= applyProductMapper.selectHotProduct();

        for(int i=0;i< loanProductList.size();i++){
            LoanProductDto loanProductDto = loanProductList.get(i);
            redisUtil.zset("topFiveLoanProduct",loanProductDto,loanProductDto.getCountProduct());
        }
        return redisUtil.zget("topFiveLoanProduct",0,4);

    }


}
