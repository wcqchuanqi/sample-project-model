package org.primary.sample.model.domain.vm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * vm基础Dto
 *
 * @author wangchuanqi
 * @version 0.0.1
 * @since 2020/12/22
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VmBaseDto {
    /**
     * vm 记录自增id.
     */
    private String id;

    /**
     * vm id.
     */
    private String vmId;

    /**
     * vm 名称.
     */
    private String vmName;

    /**
     * 创建时间.
     */
    private Date createTime;

    /**
     * 修改时间.
     */
    private Date modifyTime;
}
