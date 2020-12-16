package org.primary.sample.model.dao.orders.eneity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@TableName(value = "order_info")
public class OrderInfo {

    // 自增id （与业务无关）
    @TableId(type = IdType.AUTO)
    private String id;

    // TableField 缺失 默认映射规则，去除下划线+驼峰。如：order_id 映射为orderId
    @TableField("order_id")
    private String orderId;

    private String userId;

    private String productId;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date modifyTime;

    // https://baomidou.com/guide/logic-delete.html#%E4%BD%BF%E7%94%A8%E6%96%B9%E6%B3%95 注解使用文档
    @TableLogic
    private Integer delLogic;
}
