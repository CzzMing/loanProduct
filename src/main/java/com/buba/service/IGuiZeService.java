package com.buba.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.buba.pojo.Emp;
import com.buba.pojo.GuiZe;
import org.apache.ibatis.annotations.Result;


public interface IGuiZeService extends IService<GuiZe> {
    public Result getGuiZePage
            (int pageNow, int pageSize, String gname, String endTime);
    public Result addGuiZe(GuiZe guiZe);
    public Emp updById(int empno);
    public int empUpdate(Emp emp);
    public Result delGuiZe(int gid);
}
