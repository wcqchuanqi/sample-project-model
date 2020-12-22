package org.primary.sample.model.domain.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ExceptionUserCodeEnum implements ExceptionCodeInterface {
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
