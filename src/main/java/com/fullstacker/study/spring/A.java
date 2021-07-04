package com.fullstacker.study.spring;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @description:
 * @time: 2021/6/17 17:58
 */

public class A {
    @Resource
    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}
