package com.buba.pojo;
/**
 * @author 49466
 * @date 2023/7/19
 */

import lombok.Data;

/**
 * *@ClassName LoanProductDto
 * *@Description
 * *@Author 49466
 * *@Date 2023/7/1912:23
 * *@Version 1.0
 */
@Data
public class LoanProductDto extends  LoanProduct{
    private Integer pageSize;
    private Integer pageNum;

    private Integer countProduct;

}
