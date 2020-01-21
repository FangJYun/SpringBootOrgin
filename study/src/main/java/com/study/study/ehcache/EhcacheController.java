package com.study.study.ehcache;

import com.study.study.baseclass.BaseController;
import com.study.study.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ehcache测试
 *
 * @author fangjy
 * @date 2019-12-24 14:16
 **/
@RestController
@RequestMapping("/eh")
public class EhcacheController extends BaseController {

    @Autowired
    private EhcacheService ehcacheService;

    /**
     * http://localhost:8080/eh/getUserById?id=1
     * @param id id
     * @return User
     */
    @RequestMapping("/getUserById")
    public String getUserById(String id){
        User user = ehcacheService.getUserById(id);
        return user==null?"null":user.toString();
    }

    /**
     * http://localhost:8080/eh/updateUserById?id=1&name=test1
     * @param user
     * @return User
     */
    @RequestMapping("/updateUserById")
    public String updateUserById(User user){
        User user1 = ehcacheService.updateUserById(user);
        return user1==null?"null":user1.toString();
    }

    /**
     * http://localhost:8080/eh/delUserById?id=1
     * @param user
     * @return User
     */
    @RequestMapping("/delUserById")
    public String delUserById(String id){
        ehcacheService.delUserById(id);
        return "success";
    }

    /**
     * http://localhost:8080/eh/getUserByCache?id=1
     * @param id id
     * @return User
     */
    @RequestMapping("/getUserByCache")
    public String getUserByCache(String id){
        return ehcacheService.getUserByCache(id);
    }
}
