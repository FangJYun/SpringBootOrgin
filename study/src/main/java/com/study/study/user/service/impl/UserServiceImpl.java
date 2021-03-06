package com.study.study.user.service.impl;

import com.study.study.user.entity.User;
import com.study.study.user.mapper.UserMapper;
import com.study.study.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fangjiayun
 * @since 2019-10-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
