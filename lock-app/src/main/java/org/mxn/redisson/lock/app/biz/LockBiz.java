package org.mxn.redisson.lock.app.biz;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class LockBiz {
    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    RedissonClient redissonClient;

    public int lockAndIncr() {
        BoundValueOperations<String, String> ops = redisTemplate.boundValueOps("red");
        RLock lockz = redissonClient.getLock("lockz");
        lockz.lock();
        Integer incr;
        try {
            System.out.println("i m in");
            String red = ops.get();
            incr = Integer.valueOf(red) + 1;
            ops.set(incr.toString());
        } finally {
            lockz.unlock();
        }
        return incr;
    }
    public int incr() {
        BoundValueOperations<String, String> ops = redisTemplate.boundValueOps("red");
        Integer incr;
        System.out.println("i m in");
        String red = ops.get();
        incr = Integer.valueOf(red) + 1;
        ops.set(incr.toString());
        return incr;
    }
}
