package org.primary.sample.model.domain.exception;

import lombok.AllArgsConstructor;

/**
 * 公共异常信息枚举
 *
 * @author wangchuanqi
 * @version 0.0.1
 * @since 2020/12/21
 */

@AllArgsConstructor
public enum ExceptionCommonCodeEnum implements ExceptionCodeInterface {
    /**
     * 成功.
     */
    SUCCESS("0", "success"),
    /**
     * 失败.
     */
    FAIL("1", "fail"),
    /**
     * 参数异常.
     */
    PARAMS_ERROR("2", "参数有误");
    /**
     * code 码.
     */
    private String code;
    /**
     * 错误信息.
     */
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
