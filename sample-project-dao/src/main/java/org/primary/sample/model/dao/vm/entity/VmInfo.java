package org.primary.sample.model.dao.vm.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Vm信息entity
 * table：vm_info
 *
 * @author wangchuanqi
 * @version 0.0.1
 * @since 2020/12/17
 */
@Getter
@Setter
@TableName(value = "vm_info")
public class VmInfo {
    /**
     * 自增id （与业务无关）.
     */
    @TableId(type = IdType.AUTO)
    private String id;

//    /**
//     * 租户id(多租户默认字段tenant_id 如果使用其他字段需要修改多租户插件注入).
//     */
//    private String tenantId;
    /**
     * vm id.
     */
    private String vmId;
    /**
     * vm 名称.
     */
    private String vmName;

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
    @TableField(fill = FieldFill.INSERT)
    private Integer delLogic;
}
