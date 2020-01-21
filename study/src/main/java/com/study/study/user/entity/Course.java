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
public class Course extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 课程名
     */
    private String courseName;


}
