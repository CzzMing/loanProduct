package com.buba.mapper;
/**
 * @author 49466
 * @date 2023/9/12
 */

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.buba.pojo.Emp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * *@ClassName EmpMapper
 * *@Description
 * *@Author 49466
 * *@Date 2023/9/128:37
 * *@Version 1.0
 */
public interface EmpMapper extends BaseMapper<Emp> {
    @Select("select  \n" +
            "empno,ename,sal,comm,(case when sal+ifnull(comm,0) <=5000 then 0 \n" +
            "when sal+ifnull(comm,0)>5000 and sal+ifnull(comm,0)<=8000 then  0.03*(sal+ifnull(comm,0))\n" +
            "when sal+ifnull(comm,0)>8000 and sal+ifnull(comm,0)<=17000 then  0.1*(sal+ifnull(comm,0))\n" +
            "when sal+ifnull(comm,0)>17000 and sal+ifnull(comm,0)<=30000 then  0.2*(sal+ifnull(comm,0))\n" +
            "\n" +
            "when sal+ifnull(comm,0)>30000 and sal+ifnull(comm,0)<=40000 then  0.25*(sal+ifnull(comm,0))\n" +
            "when sal+ifnull(comm,0)>40000 and sal+ifnull(comm,0)<=60000 then  0.3*(sal+ifnull(comm,0))\n" +
            "when sal+ifnull(comm,0)>60000 and sal+ifnull(comm,0)<=85000 then  0.35*(sal+ifnull(comm,0))\n" +
            "when sal+ifnull(comm,0)>85000 then  0.45*(sal+ifnull(comm,0))\n" +
            "\n" +
            "\n" +
            "end )as tax\n" +
            "\n" +
            "from emp e left join dept d on e.deptno=d.deptno ${ew.customSqlSegment}")
    public IPage<Emp> getEmpPage(@Param(Constants.WRAPPER)
                                             Wrapper wrapper, IPage<Emp> page);

}
