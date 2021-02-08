package org.primary.sample.model.web.controller.vm;

import org.primary.sample.model.biz.vm.service.IVmWebService;
import org.primary.sample.model.common.log.WebLog;
import org.primary.sample.model.domain.common.PaginationBean;
import org.primary.sample.model.vo.ResponseBean;
import org.primary.sample.model.vo.vm.VmDetailInfoRequest;
import org.primary.sample.model.vo.vm.VmDetailInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 与虚拟相关的controller
 *
 * @author wangchuanqi
 * @version 0.0.1
 * @since 2020/12/19
 */
@RestController
@RequestMapping("/vm")
public class VmController {

    @Autowired
    IVmWebService vmWebService;

    /**
     * 获取vm详情信息列表（分页）.
     *
     * @param request 请求参数
     * @return 返回分页列表
     */
    @GetMapping(value = "info/list/v1")
    @WebLog
    public ResponseBean<PaginationBean<VmDetailInfoResponse>> vmListPagination(@RequestBody VmDetailInfoRequest request) {
        return new ResponseBean<>(vmWebService.getVmDetailInfoListWithPage(request));
    }

    /**
     * 查询单个vm详情.
     *
     * @param vmId vmId
     * @return
     */
    @GetMapping(value = "info/one/{vmId}/v1")
    @WebLog
    public ResponseBean<VmDetailInfoResponse> vmDetailInfo(@PathVariable("vmId") String vmId) {
        return new ResponseBean<>(vmWebService.getVmDetailInfo(vmId));
    }


}
