package com.fullstacker.study.spring;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @description:
 * @time: 2021/6/17 17:58
 */
@Component
public class B {
    
    @Resource
    private A a;
    
    // Currently In Creation
    public A getA() {
        return a;
    }
    
    public void setA(A a) {
        this.a = a;
    }
}
