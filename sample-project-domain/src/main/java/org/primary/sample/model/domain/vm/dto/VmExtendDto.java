package org.primary.sample.model.domain.vm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * vm 扩展信息相关的Dto
 *
 * @author wangchuanqi
 * @version 0.0.1
 * @since 2020/12/22
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VmExtendDto {

    /**
     * 自增id （与业务无关）.
     */
    private String id;
    /**
     * 扩展信息01.
     */
    private String extendInfo01;

    /**
     * 扩展信息02.
     */
    private String extendInfo02;

    /**
     * 创建时间.
     */
    private Date createTime;
    /**
     * 修改时间.
     */
    private Date modifyTime;
}
