package com.fullstacker.study.course.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: course
 * @description: 重入锁演示 重入锁又叫递归锁，当线程在外城方法中获得到锁以后，它边默认可以进入到需要相同锁的内部方法中 如示例中methodA和methodB都需要获得lock，当线程在进入到methodA中时获取到lock，那边它便可以顺利进入到methodB中
 * 而不需要在进入到methodB的时候重新获取锁
 * @author: xgs
 * @create: 2019-05-25 14:45
 */
public class ReentredLockDemo {
    
    Lock lock = new ReentrantLock();
    
    ReadWriteLock lock1 = new ReentrantReadWriteLock();
    
    public static void main(String[] args) {
        final ReentredLockDemo reentredLockDemo = new ReentredLockDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    reentredLockDemo.methodA();
                }
            }, "Thread_" + i).start();
        }
    }
    
    
    public void methodA() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "进入mthodA,获得到锁");
            methodB();
        } catch (Exception e) {
        
        } finally {
            lock.unlock();
        }
        
    }
    
    public void methodB() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "进入mthodB,获得到锁");
        } catch (Exception e) {
        
        } finally {
            lock.unlock();
        }
    }
    
}
