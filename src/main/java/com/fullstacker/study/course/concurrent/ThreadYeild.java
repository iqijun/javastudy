package com.fullstacker.study.course.concurrent;

/**
 * yeild使用示例, yeild使线程从执行状态转为就绪状态
 *
 * cpu会从众多的可执行态里选择，也就是说，当前也就是刚刚的那个线程还是有可能会被再次执行到的，
 * 并不是说一定会执行其他线程而该线程在下一次中不会执行到了
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
                    Thread.yield();
                }

            }
        },"t1");
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();

    }
}
