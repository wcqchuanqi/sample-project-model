package org.primary.sample.model.dao.vm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.primary.sample.model.dao.vm.entity.VmInfo;
import org.primary.sample.model.domain.vm.dto.VmDetailDto;

/**
 * vm信息基础接口.
 *
 * @author wangchuanqi
 * @version 0.0.1
 * @since 2020/12/22
 */
public interface IVmInfoService extends IService<VmInfo> {

    /**
     * 分页查询vm信息
     *
     * @param dto      请求条件
     * @param pageNo   页码
     * @param pageSize 每页数量
     * @return
     */
    Page<VmInfo> queryVmInfoPage(VmDetailDto dto, Integer pageNo, Integer pageSize);

    /**
     * 获取
     *
     * @param vmId vmId
     * @return
     */
    VmInfo queryVmInfoByVmId(String vmId);
}
