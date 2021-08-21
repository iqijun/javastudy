package com.fullstacker.study.course.JAVASE.cloneTest;

import com.fullstacker.study.pojo.FooClass;

/**
 * @program: course
 * @description: clone方法测试
 * @author: xgs
 * @create: 2021-04-05 16:17
 */
public class CloneTest {

    public static  void main(String[] args) throws CloneNotSupportedException {
        FooClass fooClass = new FooClass();
        Object clone = fooClass.clone();
        System.out.println(fooClass);
        System.out.println(clone);
    }
}
