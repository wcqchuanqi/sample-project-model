package org.primary.sample.model.common.util;

import cn.hutool.core.util.ArrayUtil;

import java.util.Arrays;


/**
 * 与String相关的定制处理方法
 *
 * @author wangchuanqi
 * @version 0.0.1
 * @since 2020/12/19
 */
public class StringComUtils {
    /**
     * 字符串拼接
     *
     * @param strArray 字符串
     * @return 字符串拼接结果
     */
    public static String append(String... strArray) {
        if (ArrayUtil.isNotEmpty(strArray)) {
            StringBuilder stringBuilder = new StringBuilder();
            Arrays.asList(strArray).forEach(stringBuilder::append);
            return stringBuilder.toString();
        }
        return "";
    }
}
