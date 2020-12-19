package org.primary.sample.model.common.log;

import java.lang.annotation.*;

/**
 * web log annotation
 * @since 2020/12/19
 * @author wangchuanqi
 * @version 0.0.1
 */
@Documented
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface WebLog {
}
