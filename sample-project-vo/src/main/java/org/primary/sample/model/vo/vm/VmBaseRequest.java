package org.primary.sample.model.vo.vm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.primary.sample.model.vo.RequestBean;

/**
 * vm 请求信息基类.
 *
 * @author wangchuanqi
 * @version 0.0.1
 * @since 2020/12/22
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VmBaseRequest extends RequestBean {

    /**
     * vm id.
     */
    private String vmId;

}
