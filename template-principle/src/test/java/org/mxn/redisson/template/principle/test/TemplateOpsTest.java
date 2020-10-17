package org.mxn.redisson.template.principle.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mxn.redisson.template.principle.App;
import org.mxn.redisson.template.principle.biz.TemplateOpsBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = App.class)
@RunWith(SpringRunner.class)
public class TemplateOpsTest {
    @Autowired
    TemplateOpsBiz templateOpsBiz;
    @Test
    public void getTest(){
        templateOpsBiz.doSome();
    }
}
