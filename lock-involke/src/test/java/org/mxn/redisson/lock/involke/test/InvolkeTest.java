package org.mxn.redisson.lock.involke.test;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mxn.redisson.lock.involke.App;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest(classes = App.class)
@RunWith(SpringRunner.class)
public class InvolkeTest {
    @Test
    public void involkeIncr() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                HttpClient httpClient = new HttpClient();
                try {
                    httpClient.executeMethod(new GetMethod("http://localhost:808" + (int)(Math.random() * 2) + "/lock/incr"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        Thread.sleep(5000);
    }
    @Test
    public void involkeLock() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                HttpClient httpClient = new HttpClient();
                try {
                    httpClient.executeMethod(new GetMethod("http://localhost:808" + (int)(Math.random() * 2) + "/lock/lock-incr"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        Thread.sleep(5000);
    }
}
