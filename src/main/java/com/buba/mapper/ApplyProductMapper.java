package com.buba.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.buba.pojo.ApplyProduct;
import com.buba.pojo.LoanProductDto;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 49466
 * @date 2023/8/28
 */
public interface ApplyProductMapper extends BaseMapper<ApplyProduct> {
    @Select("SELECT\n" +
            "\tp.*,countProduct\n" +
            "FROM\n" +
            "\tloan_product p\n" +
            "\tINNER JOIN ( SELECT count( product_id ) AS countProduct, product_id FROM apply_product " +
            " GROUP BY product_id ORDER BY countProduct  ) AS t ON p.id = t.product_id")
    public List<LoanProductDto>selectHotProduct();
}
