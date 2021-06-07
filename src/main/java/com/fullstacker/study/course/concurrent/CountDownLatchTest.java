package com.fullstacker.study.course.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @program: course
 * @description: CountDownLatch测试   从指定的大小减到0后才执行下面的逻辑
 * @author: xingguishuai
 * @create: 2019-05-02 15:13
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("i am thread_" + finalI);
                    countDownLatch.countDown();
                }
            }, "thread_" + i);
            thread.start();
        }
        //阻塞线程
        countDownLatch.await();
        System.out.println("执行完毕");

    }
}
