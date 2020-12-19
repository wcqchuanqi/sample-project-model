package org.primary.sample.model.dao.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.primary.sample.model.dao.user.entity.UserInfo;
import org.primary.sample.model.dao.user.mapper.UserInfoMapper;
import org.primary.sample.model.dao.user.service.IUserInfoService;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {
}
