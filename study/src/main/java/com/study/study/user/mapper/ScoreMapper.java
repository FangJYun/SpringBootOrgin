package com.study.study.user.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.study.user.entity.Score;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author fangjiayun
 * @since 2019-10-13
 */
public interface ScoreMapper extends BaseMapper<Score> {
    @Select("select score from score where #{id}")
    List<Score> selectList1(String id);

    /**
     *重写
     * @param queryWrapper 请求构造器
     * @return List<Score>
     */
    @Override
    List<Score> selectList(@Param("ew") Wrapper<Score> queryWrapper);
}
