package org.primary.sample.model.dao.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * MP相关配置
 *
 * @author wangchuanqi
 * @since 2012/12/19
 */
@Component
@Slf4j
public class MybatisFillConfig implements MetaObjectHandler {
    /**
     * insert时自动填充字段
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // insert时注册创建时间
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
        // insert时注册修改时间
        this.strictInsertFill(metaObject, "modifyTime", Date.class, new Date());
        // insert时初始化逻辑删除为0
        this.strictInsertFill(metaObject, "delLogic", Integer.class, 0);
    }

    /**
     * update时自动填充字段
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        // update时注册修改时间
        this.strictUpdateFill(metaObject, "modifyTime", Date.class, new Date());
    }
}
