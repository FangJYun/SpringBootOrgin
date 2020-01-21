package com.study.study.user.entity;

import com.study.study.baseclass.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author fangjiayun
 * @since 2019-10-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class UserScoreInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 课程id
     */
    private Integer courseId;

    /**
     * 课程名
     */
    private String courseName;

    /**
     * 得分
     */
    private Integer score;


}
