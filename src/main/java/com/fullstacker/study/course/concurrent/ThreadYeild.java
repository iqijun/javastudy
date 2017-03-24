package com.fullstacker.study.course.concurrent;

/**
 * yeild使用示例
 *
 * @author xingguishuai
 * @create 2017-03-24-15:12
 **/
public class ThreadYeild {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "=============");
                    Thread.yield();
               }

            }
        },"t");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "=============");
                }

            }
        },"t1");
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
    }
}
