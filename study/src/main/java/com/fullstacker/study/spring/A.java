package com.fullstacker.study.spring;


import javax.annotation.Resource;

/**
 * @description:
 * @time: 2021/6/17 17:58
 */

public class A {
    
    @Resource
    private B b;
    
    @Resource
    private A a;
    
    public A getA() {
        return a;
    }
    
    public B getB() {
        return b;
    }
    
    public void setB(B b) {
        this.b = b;
    }
}
