package org.primary.sample.model.domain.vm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * vm详情相关的DTO
 *
 * @author wangchuanqi
 * @version 0.0.1
 * @since 2020/12/22
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VmDetailDto extends VmBaseDto {
    /**
     * vm相关扩展信息列表.
     */
    private List<VmExtendDto> vmExtendDtoList;
}
