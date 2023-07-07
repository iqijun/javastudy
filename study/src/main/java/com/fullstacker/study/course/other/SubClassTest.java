package com.fullstacker.study.course.other;

import java.util.HashMap;

/**
 * @program: course
 * @description:
 * @author: xgs
 * @create: 2019-06-05 12:38
 */
public class SubClassTest {
    
    
    public static void main(String[] args) {
        Fater fater = new Son();
        fater.print();
        new HashMap<>();
    }
    
}

class Fater {
    
    public void print() {
        System.out.println(1234);
    }
}

class Son extends Fater {
    
    public void print() {
        System.out.println(155555);
    }
}