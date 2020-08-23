package com.wf.cache;

import com.wf.cache.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class SpringbootCacheApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RedisTemplate wfRedisTemplate;

    @Test
    void test01() {
        stringRedisTemplate.opsForValue().set("Hello", "Redis");
    }
    @Test
    void test02() {
        String hello = stringRedisTemplate.opsForValue().get("Hello");
        System.out.println(hello);
    }
    @Test
    void test03() {
        redisTemplate.opsForValue().set("emp-01", employeeService.getById(1));
    }

    @Test
    void test04() {
        wfRedisTemplate.opsForValue().set("emp-01", employeeService.getById(1));
    }
    @Test
    void test05() {
    }
    @Test
    void contextLoads() {
    }

}
