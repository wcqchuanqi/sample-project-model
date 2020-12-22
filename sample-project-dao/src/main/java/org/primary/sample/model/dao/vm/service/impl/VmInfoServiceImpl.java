package org.primary.sample.model.dao.vm.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.primary.sample.model.dao.vm.entity.VmInfo;
import org.primary.sample.model.dao.vm.mapper.VmInfoMapper;
import org.primary.sample.model.dao.vm.service.IVmInfoService;
import org.primary.sample.model.domain.vm.dto.VmDetailDto;
import org.springframework.stereotype.Service;

/**
 * vm基础信息接口实现.
 *
 * @author wangchuanqi
 * @version 0.0.1
 * @since 2020/12/22
 */
@Service
public class VmInfoServiceImpl extends ServiceImpl<VmInfoMapper, VmInfo> implements IVmInfoService {

    @Override
    public Page<VmInfo> queryVmInfoPage(VmDetailDto dto, Integer pageNo, Integer pageSize) {
        Page<VmInfo> page = new Page<>(pageNo, pageSize);
        return this.page(page, Wrappers.<VmInfo>lambdaQuery()
                .select(VmInfo::getId, VmInfo::getVmId, VmInfo::getVmName)
                .eq(StringUtils.isNotBlank(dto.getVmId()), VmInfo::getVmId, dto.getVmId())
                .like(StringUtils.isNotBlank(dto.getVmName()), VmInfo::getVmName, dto.getVmName())
                .orderByAsc(VmInfo::getCreateTime));
    }

    @Override
    public VmInfo queryVmInfoByVmId(String vmId) {
        return baseMapper.queryVmInfoOne(Wrappers.<VmInfo>lambdaQuery().eq(VmInfo::getVmId, vmId));
    }

}
