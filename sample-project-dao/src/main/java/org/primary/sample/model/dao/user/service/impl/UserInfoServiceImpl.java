package org.primary.sample.model.dao.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.primary.sample.model.dao.user.entity.UserInfo;
import org.primary.sample.model.dao.user.mapper.UserInfoMapper;
import org.primary.sample.model.dao.user.service.IUserInfoService;
import org.springframework.stereotype.Service;

/**
 * 用户基础信息接口实现.
 *
 * @author wangchuanqi
 * @version 0.0.1
 * @since 2020/12/22
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {
}
