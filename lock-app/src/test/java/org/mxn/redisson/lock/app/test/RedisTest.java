package org.mxn.redisson.lock.app.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mxn.redisson.lock.app.App;
import org.mxn.redisson.lock.app.biz.LockBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = App.class)
@RunWith(SpringRunner.class)
public class RedisTest {
    @Autowired
    LockBiz lockBiz;

    @Test
    public void serializeOps(){
        lockBiz.serializeOps();
    }

    @Test
    public void lockPrinciple(){
        lockBiz.lockAndIncr();
    }

}
