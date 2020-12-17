package org.primary.sample.model.dao.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 用户信息entity
 * table：user_info
 *
 * @author wangchuanqi
 * @since 2020/12/17
 * @version 0.0.1
 */
@Getter
@Setter
@TableName(value = "user_info")
public class UserInfo {
    /**
     * 自增id （与业务无关）.
     */
    @TableId(type = IdType.AUTO)
    private String id;
    /**
     * 用户id.
     */
    @TableField(value = "user_id")
    private String userId;
    /**
     * 用户名称.
     * 省略 @TableField  表字段与属性字段映射关系。user_name --> userName
     */
    private String userName;
    /**
     * 角色id.
     */
    private String roleId;
    /**
     * 创建时间.
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
