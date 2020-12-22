package org.primary.sample.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 分页请求类.
 *
 * @author wangchuanqi
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestBean {
    /**
     * 页码.
     */
    private Integer pageNo;
    /**
     * 每页数量.
     */
    private Integer pageSize;
    /**
     * 操作人.
     */
    private String operatorId;
    /**
     * 开始时间(用于按照时间端查找，Long 时间戳).
     */
    private Long startTime;
    /**
     * 结束时间.
     */
    private Long endTime;
}
