package org.primary.sample.model.biz.vm.transform;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.primary.sample.model.dao.vm.entity.VmExtendInfo;
import org.primary.sample.model.dao.vm.entity.VmInfo;
import org.primary.sample.model.domain.vm.dto.VmDetailDto;
import org.primary.sample.model.vo.vm.VmDetailInfoRequest;
import org.primary.sample.model.vo.vm.VmDetailInfoResponse;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 与vm相关的dto与vo之间转型.
 *
 * @author wangchuanqi
 * @version 0.0.1
 * @since 2020/12/22
 */
@Slf4j
public class VmDtoAndVo {
    /**
     * VmDetailInfoRequest To VmDetailDto
     *
     * @param request request
     * @return VmDetailDto
     */
    public static VmDetailDto vmDetailInfoRequestToVmDetailDto(VmDetailInfoRequest request) {
        VmDetailDto detailDto = new VmDetailDto();
        BeanUtils.copyProperties(request, detailDto);
        return detailDto;
    }

    /**
     * 获取VmDetailInfoResponse 列表.
     *
     * @param vmExtendInfoList vm扩展信息列表
     * @param vmInfoList       vm信息列表
     * @return VmDetailInfoResponse list
     */
    public static List<VmDetailInfoResponse> vmInfoAndVmExtendInfoToVmDetailInfoResponse(List<VmExtendInfo> vmExtendInfoList, List<VmInfo> vmInfoList) {
        Map<String, List<VmExtendInfo>> vmExtendInfoMap = vmExtendInfoList.stream().collect(Collectors.groupingBy(VmExtendInfo::getVmId));
        log.info("vmExtendInfoMap：{}", JSONUtil.toJsonStr(vmExtendInfoMap));
        List<VmDetailInfoResponse> vmDetailInfoResponseList = vmInfoList.stream().map(item -> {
            VmDetailInfoResponse infoResponse = new VmDetailInfoResponse();
            BeanUtils.copyProperties(item, infoResponse);
            log.info("item：{}", JSONUtil.toJsonStr(vmExtendInfoMap));
            // 转换扩展信息
            List<VmDetailInfoResponse.VmExtendInfoVo> vmExtendInfoVoList = vmExtendInfoMap.get(item.getVmId()).stream().map(extend -> {
                VmDetailInfoResponse.VmExtendInfoVo vmExtendInfo = new VmDetailInfoResponse().new VmExtendInfoVo();
                BeanUtils.copyProperties(extend, vmExtendInfo);
                return vmExtendInfo;
            }).collect(Collectors.toList());
            infoResponse.setVmExtendInfoVoList(vmExtendInfoVoList);
            return infoResponse;
        }).collect(Collectors.toList());
        return vmDetailInfoResponseList;
    }

    /**
     * 初始化 VmDetailInfoResponse.VmExtendInfoVoList
     *
     * @param response         返回值
     * @param vmExtendInfoList vm扩展信息列表
     */
    public static void vmExtendInfoToVmDetailInfoResponse(VmDetailInfoResponse response, List<VmExtendInfo> vmExtendInfoList) {
        response.setVmExtendInfoVoList(
                vmExtendInfoList.stream().map(extend -> {
                    VmDetailInfoResponse.VmExtendInfoVo vmExtendInfo = new VmDetailInfoResponse().new VmExtendInfoVo();
                    BeanUtils.copyProperties(vmExtendInfo, extend);
                    return vmExtendInfo;
                }).collect(Collectors.toList()));
    }

}
