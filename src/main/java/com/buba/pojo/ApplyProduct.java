package com.buba.pojo;
/**
 * @author 49466
 * @date 2023/8/28
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * *@ClassName ApplyProduct
 * *@Description
 * *@Author 49466
 * *@Date 2023/8/2814:11
 * *@Version 1.0
 */
@Data
public class ApplyProduct {
    @TableId(value="id",type= IdType.AUTO)

    private Long id;

   private Long productId;

   private Long userId;
}
