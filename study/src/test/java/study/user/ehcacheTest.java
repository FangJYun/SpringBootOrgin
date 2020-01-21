package study.user;

import com.study.study.ehcache.EhcacheService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import study.BaseTest;

/**
 * ehcache测试
 *
 * @author fangjy
 * @date 2019-12-24 10:52
 **/
public class ehcacheTest extends BaseTest {
    @Autowired
    private EhcacheService ehcacheService;
    @Test
    public void getUser(){
        //User user = ehcacheService.getUserById(1);
        //System.out.println(user.toString());
        System.out.println(System.getProperty("java.io.tmpdir"));
    }
}
