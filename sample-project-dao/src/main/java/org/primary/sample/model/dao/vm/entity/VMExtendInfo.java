package org.primary.sample.model.dao.vm.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * vm 扩展信息 eneity
 * table：vm_extend_info
 */
@Setter
@Getter
@TableName(value = "vm_extend_info")
public class VMExtendInfo {

    /**
     * 自增id （与业务无关）.
     */
    @TableId(type = IdType.AUTO)
    private String id;

    /**
     * vm id.
     */
    private String vmId;

    /**
     * 扩展信息01.
     */
    private String extendInfo01;

    /**
     * 扩展信息02.
     */
    private String extendInfo02;

    /**
     * 创建时间.
     * PS：字典设计规范，统一相同含义字段名称
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 修改时间.
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date modifyTime;

    /**
     * 逻辑删除.
     * 1表示删除无效数据；
     * 0表示有效数据
     * https://baomidou.com/guide/logic-delete.html#%E4%BD%BF%E7%94%A8%E6%96%B9%E6%B3%95 注解使用文档
     */
    @TableLogic
    private Integer delLogic;
}
