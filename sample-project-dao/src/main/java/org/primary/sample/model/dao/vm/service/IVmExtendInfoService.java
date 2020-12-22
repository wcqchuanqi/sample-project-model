package org.primary.sample.model.dao.vm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.primary.sample.model.dao.vm.entity.VmExtendInfo;

import java.util.List;

/**
 * vm扩展信息基础接口.
 *
 * @author wangchuanqi
 * @version 0.0.1
 * @since 2020/12/22
 */
public interface IVmExtendInfoService extends IService<VmExtendInfo> {
    /**
     * 获取扩展信息列表
     *
     * @param VmId VmId
     * @return VmExtendInfo 列表
     */
    List<VmExtendInfo> queryVmExtendInfoList(String VmId);
}
