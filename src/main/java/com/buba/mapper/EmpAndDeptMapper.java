package com.buba.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.buba.pojo.Emp;
import com.buba.pojo.EmpAndDept;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface EmpAndDeptMapper extends MPJBaseMapper<EmpAndDept> {
    @Select("select empno,ename,sal,comm,dname," +
           " case when sal+ifnull(comm,0) <=5000 then 0" +
            "when sal+ifnull(comm,0)>5000 and sal+ifnull(comm,0)<=8000 then  0.03*(sal+ifnull(comm,0))\n" +
            "when sal+ifnull(comm,0)>8000 and sal+ifnull(comm,0)<=17000 then  0.1*(sal+ifnull(comm,0))\n" +
            "when sal+ifnull(comm,0)>17000 and sal+ifnull(comm,0)<=30000 then  0.2*(sal+ifnull(comm,0))\n"+

            "when sal+ifnull(comm,0)>30000 and sal+ifnull(comm,0)<=40000 then  0.25*(sal+ifnull(comm,0))\n"+
            "when sal+ifnull(comm,0)>40000 and sal+ifnull(comm,0)<=60000 then  0.3*(sal+ifnull(comm,0))\n"+
            "when sal+ifnull(comm,0)>60000 and sal+ifnull(comm,0)<=85000 then  0.35*(sal+ifnull(comm,0))\n"+
            "when sal+ifnull(comm,0)>85000 then  0.45*(sal+ifnull(comm,0))\n"+
            "end as tax,"+

            "e.sal+innull(comm,0) - (case\n"+
            "when e.sal between 1 and 5000 then 0\n"+
            "when e.sal between 5001 and 8000 then e.sal * 0.03\n"+
            "when e.sal between 8001 and 17000 then e.sal * 0.1\n"+
            "when e.sal between 17001 and 30000 then e.sal * 0.2\n"+
            "when e.sal between 30001 and 40000 then e.sal * 0.25\n"+
            "when e.sal between 40001 and 60000 then e.sal * 0.3\n"+
            "when e.sal between 60001 and 85000 then e.sal * 0.35\n"+
            "when e.sal >= 85001 then e.sal * 0.45\n"+
            "END) as sjsr\n" +
    "from emp e left join dept d on e.deptno=d.deptno")
    public IPage<Emp> getEmpPage(@Param(Constants.WRAPPER)
                                         Wrapper wrapper, IPage<Emp> page);

}
