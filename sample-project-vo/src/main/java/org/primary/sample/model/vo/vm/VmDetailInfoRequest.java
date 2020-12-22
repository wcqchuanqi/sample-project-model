package org.primary.sample.model.vo.vm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * vm详情信息请求值.
 *
 * @author wangchuanqi
 * @version 0.0.1
 * @since 2020/12/22
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VmDetailInfoRequest extends VmBaseRequest {
    /**
     * vm 名称.
     */
    private String vmName;
}
