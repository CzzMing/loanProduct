package com.buba.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("sys_menu")
public class Menu {
    @TableId(value = "menu_id",type = IdType.AUTO)
    private Long menuId;
    private String menuName;
    private Long parentId;
    private Integer orderNum;
    private String path;
    private String component;
    private Integer isFrame;
    private Integer isCache;
    private String visible;
    private String status;
    private String perms;
    private String icon;
    private String createTime;
    private String createBy;
    private String updateTime;
    private String updateBy;
    private String remark;

    private List<Menu> children;
}
