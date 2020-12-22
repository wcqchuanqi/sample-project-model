package org.primary.sample.model.biz.vm.service;

import org.primary.sample.model.domain.common.PaginationBean;
import org.primary.sample.model.vo.vm.VmDetailInfoRequest;
import org.primary.sample.model.vo.vm.VmDetailInfoResponse;

/**
 * vm相关同步业务管理接口.
 *
 * @author wangchuanqi
 */
public interface IVmWebService {

    /**
     * 查询vm详情信息列表（分页）.
     *
     * @param request 查询参数
     * @return 返回值
     */
    PaginationBean<VmDetailInfoResponse> getVmDetailInfoListWithPage(VmDetailInfoRequest request);

    /**
     * 获取vm详情信息
     *
     * @param vmId vmId
     * @return VmDetailInfoResponse
     */
    VmDetailInfoResponse getVmDetailInfo(String vmId);
}
