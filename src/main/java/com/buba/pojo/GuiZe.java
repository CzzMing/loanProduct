package com.buba.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("guize")
public class GuiZe {
    /**
     * 规则id
     */
    @TableId(value = "gid", type= IdType.AUTO)
    private Integer gid;
    private String gname;//规则名称,

    @TableField("begin_time")
    private String beginTime;// '开始时间',
    @TableField("end_time")
    private String endTime;// '结束时间',
    private String onLine;// '1上线 0 下线',
    private String remark;// '备注',
    private String ops;// '1 通过 2 拒绝 3 人工审核',
    private String quan;// '风险权重',
}
