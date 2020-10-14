package org.mxn.redisson.lock.app.controller;

import org.mxn.redisson.lock.app.biz.LockBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lock")
public class LockController {
    @Autowired
    LockBiz lockBiz;

    @GetMapping("/lock-incr")
    public int lockAndIncr(){
        return lockBiz.lockAndIncr();
    }

    @GetMapping("/incr")
    public int incr(){
        return lockBiz.incr();
    }
}
