package org.mxn.redisson.template.principle.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class TemplateOpsBiz {
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public void doSome(){
        Object red = redisTemplate.opsForValue().get("red");
        System.out.println(red);
    }
}
