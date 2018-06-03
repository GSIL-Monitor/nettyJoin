package com.redis;

import com.netty.dao.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author anthony_xu
 * @create $ID: RedisTest, v0.1 2018年05月31日 21:26 anthony_xu Exp $
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() {
        stringRedisTemplate.opsForValue().set("aaa", "123");
        Assert.assertEquals("123", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testObj() throws InterruptedException {
        User user = new User();
        user.setCertName("anthony");
        user.setCertNo("9998");
        user.setcTime("ctime");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("com.neo.x", user);
        operations.set("com.neo.f", user, 1, TimeUnit.SECONDS);

        Thread.sleep(1000);

        boolean exists = redisTemplate.hasKey("com.neo.f");
        if (exists) {
            System.out.println("exist");
        } else {
            System.out.println("not exist");
        }

        boolean xE = redisTemplate.hasKey("com.neo.x");
        if (xE) {
            System.out.println("xE exist");
        } else {
            System.out.println("xE not exist");
        }
    }
}
