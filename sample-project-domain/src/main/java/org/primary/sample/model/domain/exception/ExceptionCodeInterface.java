package org.primary.sample.model.domain.exception;

/**
 * exception code 共性接口.
 *
 * @author wangchuanqi
 * @version 0.0.1
 * @since 2020/12/21
 */
public interface ExceptionCodeInterface {

    /**
     * exception code
     *
     * @return code
     */
    String getCode();

    /**
     * exception info
     *
     * @return msg
     */
    String getMsg();
}
