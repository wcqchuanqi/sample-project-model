package org.primary.sample.model.domain.exception;

import lombok.AllArgsConstructor;

/**
 * 虚拟相关异常信息枚举.
 *
 * @author wangchuanqi
 * @version 0.0.1
 * @since 2020/12/21
 */
@AllArgsConstructor
public enum ExceptionVmCodeEnum implements ExceptionCodeInterface {

    /**
     *
     */
    SUCCESS("0", "success"),
    /**
     *
     */
    FAIL("1", "fail"),
    /**
     *
     */
    PARAMS_ERROR("2", "参数有误");

    private String code;

    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
