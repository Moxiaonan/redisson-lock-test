package org.mxn.redisson.template.principle.biz;

import org.mxn.rdsu.spring.starter.util.RdsuUtil;
import org.mxn.redisson.template.principle.entity.Product;
import org.mxn.redisson.template.principle.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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

    public User mapOps(){
        String key = "rdsu-map";
        rdsuUtil.hSet(key,"mxn",new User("mxn",3));
        rdsuUtil.hSet(key,"hy",new User("hy",4));
        rdsuUtil.hSet(key,"2233",new Product("2233","face mask",100));
        rdsuUtil.hSet(key,"6677",new Product("6677","sport shoe",200));

        User user = rdsuUtil.hGet(key, "hy", User.class);
        System.out.println(user);
        Product product = rdsuUtil.hGet(key, "2233", Product.class);
        System.out.println(product);
        return null;
    }

    public void setOps(){
        String key = "rdsu-set";
        rdsuUtil.sAdd(key,new User("mxn",3),new User("hy",4));
        Set<User> users = rdsuUtil.sMembers(key, User.class);
        System.out.println(users);
    }
}
