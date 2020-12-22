package org.primary.sample.model.vo.vm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * vm 详情信息返回值.
 *
 * @author wangchuanqi
 * @version 0.0.1
 * @since 2020/12/22
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VmDetailInfoResponse {
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
     * vm扩展信息列表.
     */
    private List<VmExtendInfoVo> vmExtendInfoVoList;

    /**
     * vm扩展信息
     *
     * @author wangchuanqi
     * @version 0.0.1
     * @since 2020/12/22
     */
    @Setter
    @Getter
    public class VmExtendInfoVo {
        /**
         * 扩展信息01.
         */
        private String extendInfo01;

        /**
         * 扩展信息02.
         */
        private String extendInfo02;
    }
}


