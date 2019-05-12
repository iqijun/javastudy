package com.fullstacker.study.course.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: course
 * @description: lock使用示例，绑定多条件，顺序唤醒线程
 *
 * 线程A执行方法A，执行完成后唤醒线程B执行方法B，然后唤醒线程C执行方法C
 * @author: xingguishuai
 * @create: 2019-05-12 15:33
 */

class Executions{
    private  String flag = "A";//设置一个flag用来标识应该哪条线程执行
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c3 = lock.newCondition();
    private Condition c2 = lock.newCondition();

    public  void aMethod(){
        lock.lock();
        try {
            while (!"A".equalsIgnoreCase(flag)){
                c1.wait();
            }
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName()+",echo A");
            }
            flag = "B";//将flag置为B
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public  void bMethod(){
        lock.lock();
        try {
            while (!"B".equalsIgnoreCase(flag)){
                c1.wait();
            }
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName()+",echo B");
            }
            flag = "C";//将flag置为B
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public  void cMethod(){
        lock.lock();
        try {
            while (!"C".equalsIgnoreCase(flag)){
                c3.wait();
            }
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName()+",echo C");
            }
            flag = "A";//将flag置为B
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
public class ReentrantLockDemo {
    public static  void main(String[] args){

        final Executions executions = new Executions();
        new Thread(new Runnable() {
            @Override
            public void run() {
                executions.aMethod();
            }
        },"Thead_A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                executions.bMethod();
            }
        },"Thead_B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                executions.cMethod();
            }
        },"Thead_C").start();
    }
}
