package org.primary.sample.model.dao.vm.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.primary.sample.model.dao.vm.entity.VmInfo;

/**
 * vm信息mapper.
 *
 * @author wangchuanqi
 * @version 0.0.1
 * @since 2020/12/22
 */
public interface VmInfoMapper extends BaseMapper<VmInfo> {
    /**
     * 查询vm 信息.
     *
     * @param wrapper 请求参数
     * @return
     */
    @Select("select id,vm_id,vm_name from vm_info ${ew.customSqlSegment}")
    VmInfo queryVmInfoOne(@Param(Constants.WRAPPER) Wrapper<VmInfo> wrapper);
}
