package study.user;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.study.user.entity.Score;
import com.study.study.user.entity.User;
import com.study.study.user.entity.UserScoreInfo;
import com.study.study.user.mapper.ScoreMapper;
import com.study.study.user.mapper.UserScoreInfoMapper;
import com.study.study.user.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import study.BaseTest;

import java.util.List;


/**
 * 用户测试类
 *
 * @author fangjy
 * @date 2019-10-12 13:53
 **/
public class UserTest extends BaseTest {
    @Autowired
    private IUserService userService;
    @Autowired
    private ScoreMapper scoreMapper;

    @Autowired
    private UserScoreInfoMapper userScoreInfoMapper;


    /**
     * 同名覆盖
     */
    @Test
    public void getScoresTest(){
        QueryWrapper<Score> wrapper = new QueryWrapper<>();
        List<Score> users = scoreMapper.selectList(wrapper);
        System.out.println(JSON.toJSONString(users));
    }

    /**
     * service分页调用
     */
    @Test
    public void userSelectTest(){
        List<User> users = userService.page(new Page<>(1,3)).getRecords();
        System.out.println(JSON.toJSONString(users));
    }


    /**
     * 条件构造器
     */
    @Test
    public void getUserScoreInfoByWrapper(){
        String name = "";
        QueryWrapper<UserScoreInfo> wrapper = new QueryWrapper<>();
        wrapper.apply("score.user_id = user.id and score.course_id = course.id")
                .eq(!StringUtils.isEmpty(name),"user.name",name)
                .gt("score.score",85);
        List<UserScoreInfo> users = userScoreInfoMapper.getUserScoreInfoByWrapper(wrapper);
        System.out.println(JSON.toJSONString(users));
    }
}
