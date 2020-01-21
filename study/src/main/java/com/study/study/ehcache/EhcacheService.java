package com.study.study.ehcache;

import com.study.study.user.entity.User;
import com.study.study.user.service.IUserService;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 测试ehcache
 *
 * @author fangjy
 * @date 2019-12-19 17:28
 **/
@Service
public class EhcacheService {
    @Autowired
    private IUserService userService;

    @Cacheable(value = "user",key="#id",unless = "#result==null")
    public User getUserById(String id){
        System.out.println("执行方法:getUserById:"+id);
        return userService.getById(id);
    }

    @CachePut(value = "user",key="#user.id",unless = "#result==null")
    public User updateUserById(User user){
        System.out.println("执行方法:updateUserById:"+user.getId());
        userService.updateById(user);
        return user;
    }

    @CacheEvict(value = "user",key = "#id")
    public void delUserById(String id){
        System.out.println("执行方法:delUserById:"+id);
    }

    String getUserByCache(String id){
        CacheManager cacheManager = CacheManager.getInstance();
        Cache cache = cacheManager.getCache("user");
        CacheConfiguration configuration = cache.getCacheConfiguration();
        configuration.setTimeToLiveSeconds(120);
        Element result = cache.get(id);
        return "缓存:key:"+result.getObjectKey()+"  value:"+result.getObjectValue();
    }

}
