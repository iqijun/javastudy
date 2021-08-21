package com.fullstacker.study.course.JAVASE;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: course
 * @description: 变长参数测试
 * @author: xgs
 * @create: 2019-05-30 14:56
 */
public class VarArgsTest {

    public void print(String... args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }

    public void print(String test) {
        System.out.println("----------");
    }

    public static void main(String[] args) {
        VarArgsTest test = new VarArgsTest();
//        test.print("hello");
//        test.print("hello", "alexia");
        test.print(new String[]{"1234", "10040"});

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();
    }
}
