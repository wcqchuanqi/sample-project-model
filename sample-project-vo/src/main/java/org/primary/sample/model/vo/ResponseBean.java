package org.primary.sample.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.primary.sample.model.domain.exception.ExceptionCodeInterface;
import org.primary.sample.model.domain.exception.ExceptionVmCodeEnum;

import java.io.Serializable;

/**
 * 返回值VO封装类.
 *
 * @author wangchuanqi
 * @version 0.0.1
 * @since 2020/12/21
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBean<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * code 码,各业务模块分别定义，方便定位问题.
     */
    private String code;
    /**
     * 消息,用于给接收者提示使用.
     */
    private String msg;
    /**
     * Vo的实体
     */
    private T data;

    /**
     * 构造函数：code， msg.
     *
     * @param code code
     * @param msg  msg
     */
    public ResponseBean(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 构造函数:data.
     *
     * @param data data
     */
    public ResponseBean(T data) {
        this.code = ExceptionVmCodeEnum.SUCCESS.getCode();
        this.msg = ExceptionVmCodeEnum.SUCCESS.getMsg();
        this.data = data;
    }

    /**
     * 构造函数:codeEnum,data.
     *
     * @param codeEnum codeEnum
     * @param data     data
     */
    public ResponseBean(ExceptionCodeInterface codeEnum, T data) {
        this.code = codeEnum.getCode();
        this.msg = codeEnum.getMsg();
        this.data = data;
    }

    /**
     * 构造函数:codeEnum.
     *
     * @param codeEnum codeEnum
     */
    public ResponseBean(ExceptionCodeInterface codeEnum) {
        this.code = codeEnum.getCode();
        this.msg = codeEnum.getMsg();
    }

    /**
     * 构造函数<T>:codeEnum,data.
     *
     * @param codeEnum codeEnum
     * @param data     data
     * @return VoResponse
     */
    public ResponseBean<T> setResponseBean(ExceptionCodeInterface codeEnum, T data) {
        this.setCode(codeEnum.getCode());
        this.setMsg(codeEnum.getMsg());
        this.setData(data);
        return this;
    }

    /**
     * 构造函数:codeEnum.
     *
     * @param codeEnum codeEnum
     * @return VoResponse
     */
    public ResponseBean<T> setResponseBean(ExceptionCodeInterface codeEnum) {
        this.setCode(codeEnum.getCode());
        this.setMsg(codeEnum.getMsg());
        return this;
    }
}
