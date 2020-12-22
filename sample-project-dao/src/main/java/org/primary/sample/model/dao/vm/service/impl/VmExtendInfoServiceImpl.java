package org.primary.sample.model.dao.vm.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.primary.sample.model.dao.vm.entity.VmExtendInfo;
import org.primary.sample.model.dao.vm.mapper.VmExtendInfoMapper;
import org.primary.sample.model.dao.vm.service.IVmExtendInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * vm扩展信息接口实现.
 *
 * @author wangchuanqi
 * @version 0.0.1
 * @since 2020/12/22
 */
@Service
public class VmExtendInfoServiceImpl extends ServiceImpl<VmExtendInfoMapper, VmExtendInfo> implements IVmExtendInfoService {
    @Override
    public List<VmExtendInfo> queryVmExtendInfoList(String vmId) {
        return baseMapper.queryVmExtendInfoList(Wrappers.<VmExtendInfo>lambdaQuery().eq(VmExtendInfo::getVmId, vmId));
    }
}
