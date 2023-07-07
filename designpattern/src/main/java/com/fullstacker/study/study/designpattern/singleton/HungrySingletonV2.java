package com.fullstacker.study.study.designpattern.singleton;

/**
 * @program: course
 * @description: 升级版的饿汉模式
 * @author: xgs
 * @create: 2019-01-19 23:48
 */
public class HungrySingletonV2 {
    
    private HungrySingletonV2() {
    }
    
    public HungrySingletonV2 getInstance() {
        
        return Nested.instance;
    }
    
    private static class Nested {
        
        private static final HungrySingletonV2 instance = new HungrySingletonV2();
    }
}
