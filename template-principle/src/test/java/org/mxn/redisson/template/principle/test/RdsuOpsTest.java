package org.mxn.redisson.template.principle.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mxn.redisson.template.principle.App;
import org.mxn.redisson.template.principle.biz.RdsuOpsBiz;
import org.mxn.redisson.template.principle.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = App.class)
@RunWith(SpringRunner.class)
public class RdsuOpsTest {
    @Autowired
    RdsuOpsBiz rdsuOpsBiz;

    @Test
    public void getOps(){
        System.out.println(rdsuOpsBiz.getOps("rdsu"));
    }

    @Test
    public void listOps(){
        List<User> users = rdsuOpsBiz.listOps();
        for (User user : users) {
            System.out.println(user.toString());
        }
    }
}
