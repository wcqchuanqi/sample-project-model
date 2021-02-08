package org.primary.sample.model.biz.vm.service.Impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.primary.sample.model.biz.vm.service.IVmWebService;
import org.primary.sample.model.biz.vm.transform.VmDtoAndVo;
import org.primary.sample.model.dao.vm.entity.VmExtendInfo;
import org.primary.sample.model.dao.vm.entity.VmInfo;
import org.primary.sample.model.dao.vm.service.IVmExtendInfoService;
import org.primary.sample.model.dao.vm.service.IVmInfoService;
import org.primary.sample.model.domain.common.PaginationBean;
import org.primary.sample.model.vo.vm.VmDetailInfoRequest;
import org.primary.sample.model.vo.vm.VmDetailInfoResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * vm相关同步业务管理接口实现类.
 *
 * @author wangchuanqi
 * @version 0.0.1
 * @since 2020/12/22
 */
@Service
public class VmWebServiceImpl implements IVmWebService {

    @Autowired
    IVmInfoService vmInfoService;

    @Autowired
    IVmExtendInfoService vmExtendInfoService;

    /**
     * 案例 说明：一般需求不会查询vm详情，而是查询vm列表，但后点击根据vmId查询单个vm详情。
     * 这里这么写时为了表述两个内容：
     * 1. MP实现分页；
     * 2.JDK8 stream 较多应用：list<T>转set<String>  list<T> 分组转map<String,T>等；
     */
    @Override
    public PaginationBean<VmDetailInfoResponse> getVmDetailInfoListWithPage(VmDetailInfoRequest request) {
        PaginationBean<VmDetailInfoResponse> response = new PaginationBean<>(0L, new ArrayList<>());
        // 1 获取vm基础信息
        Page<VmInfo> vmInfoPage = vmInfoService.queryVmInfoPage(VmDtoAndVo.vmDetailInfoRequestToVmDetailDto(request), request.getPageNo(), request.getPageSize());
        // 2.获取扩展信息
        if (CollectionUtils.isNotEmpty(vmInfoPage.getRecords())) {
            Set<String> vmIdSet = vmInfoPage.getRecords().stream().map(VmInfo::getVmId).collect(Collectors.toSet());
            List<VmExtendInfo> vmExtendInfoList = vmExtendInfoService.list(Wrappers.<VmExtendInfo>lambdaQuery()
                    .in(VmExtendInfo::getVmId, vmIdSet));
            response.setTotalCount(vmInfoPage.getTotal());
            response.setDataList(VmDtoAndVo.vmInfoAndVmExtendInfoToVmDetailInfoResponse(vmExtendInfoList, vmInfoPage.getRecords()));
        }
        return response;
    }

    /**
     * 使用MP注解的形式执行sql 和 直接xml.
     */
    @Override
    public VmDetailInfoResponse getVmDetailInfo(String vmId) {
        VmDetailInfoResponse response = new VmDetailInfoResponse();
        VmInfo vmInfo = vmInfoService.queryVmInfoByVmId(vmId);
        if (null != vmInfo) {
            BeanUtils.copyProperties(vmInfo, response);
            VmDtoAndVo.vmExtendInfoToVmDetailInfoResponse(response, vmExtendInfoService.queryVmExtendInfoList(vmId));
        }
        return response;
    }


}
