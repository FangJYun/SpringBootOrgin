package com.study.study.user.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.study.study.user.entity.UserScoreInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author :fjy
 */
public interface UserScoreInfoMapper {

    /**
     * 通过条件获取用户分数信息
     * @param wrapper 条件构造器
     * @return List<UserScoreInfo>
     */
    List<UserScoreInfo> getUserScoreInfoByWrapper(@Param(Constants.WRAPPER) Wrapper<UserScoreInfo> wrapper);
}
