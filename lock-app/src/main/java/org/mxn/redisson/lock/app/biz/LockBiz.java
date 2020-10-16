package org.mxn.redisson.lock.app.biz;

import org.mxn.redisson.lock.app.entity.User;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LockBiz {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedissonClient redissonClient;

    public int lockAndIncr() {
        BoundValueOperations<String, String> ops = stringRedisTemplate.boundValueOps("red");
//        获取锁
        RLock lockz = redissonClient.getLock("lockz");
//        加锁
        lockz.lock();
        Integer incr;
        try {
            String red = ops.get();
            incr = Integer.valueOf(red) + 1;
            ops.set(incr.toString());
        } finally {
//            解锁
            lockz.unlock();
        }
        return incr;
    }
    public int incr() {
        BoundValueOperations<String, String> ops = stringRedisTemplate.boundValueOps("red");
        Integer incr;
        String red = ops.get();
        incr = Integer.valueOf(red) + 1;
        ops.set(incr.toString());
        return incr;
    }
    public String serializeOps(){
//        BoundValueOperations ops = redisTemplate.boundValueOps("user");
//        ArrayList<User> users = new ArrayList<>();
//        users.add(new User("hy",18));
//        users.add(new User("mxn",19));
//        ops.set(users);
//
//        List<User> userList = (List<User>) ops.get();
//        System.out.println(userList);

        BoundListOperations ops = redisTemplate.boundListOps("user-list");
        ops.leftPush(new User("hy",18));
        ops.leftPush(new User("mxn",19));

        List range = ops.range(0, -1);
        System.out.println(range);
        return null;
    }
}
