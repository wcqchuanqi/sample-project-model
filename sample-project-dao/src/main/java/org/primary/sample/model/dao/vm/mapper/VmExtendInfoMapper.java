package org.primary.sample.model.dao.vm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.primary.sample.model.dao.vm.entity.VmExtendInfo;

import java.util.List;

/**
 * vm扩展信息
 *
 * @author wangchuanqi
 * @version 0.0.1
 * @since 2020/12/22
 */
public interface VmExtendInfoMapper extends BaseMapper<VmExtendInfo> {


    /**
     * 获取vm扩展信息(sql).
     *
     * @param vmExtendInfo vmExtendInfo
     * @return
     */
    List<VmExtendInfo> queryVmExtendInfoListSQL(VmExtendInfo vmExtendInfo);
}
