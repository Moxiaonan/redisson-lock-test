package org.mxn.redisson.template.principle.biz;

import org.mxn.rdsu.spring.starter.util.RdsuUtil;
import org.mxn.redisson.template.principle.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RdsuOpsBiz {
    @Autowired
    RdsuUtil rdsuUtil;

    public User getOps(String key){
        rdsuUtil.set("rdsu",new User("mxn",3));
        return rdsuUtil.get(key,User.class);
    }

    public List<User> listOps(){
        String key = "rdsu-list";
        rdsuUtil.lPush(key,new User("mxn",3));
        rdsuUtil.lPush(key,new User("hy",1));
        System.out.println(rdsuUtil.lIndex(key,0).toString());
        return rdsuUtil.lRange(key,0,-1,User.class);
    }
}
