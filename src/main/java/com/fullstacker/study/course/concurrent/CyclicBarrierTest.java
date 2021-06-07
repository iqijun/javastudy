package com.fullstacker.study.course.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @program: course
 * @description: cyclicBarrier    从0累加到某个数值后才能继续执行下面的逻辑  比如要凑齐n个人开会，一定要等到所有的人到齐后才能开始会议
 * @author: xingguishuai
 * @create: 2019-05-02 15:32
 */
public class CyclicBarrierTest {


    public static void main(String[] args) {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(7, new Runnable() {
            @Override
            public void run() {
                System.out.println("人到齐了，准备开会，开会进行中.....");

                try {
                    TimeUnit.SECONDS.sleep(3L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("会议结束，散会，回去干活。。。。");
            }
        });

        for (int i = 1; i <= 7; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("第" + finalI + "个到达会议室是" + Thread.currentThread().getName());
                    try {
                        //由于人没到齐，所以提前达到会议室的要等待，线程阻塞
                        int await = cyclicBarrier.await();
                        System.out.println("await::" + await + ",开完会了。。。" + Thread.currentThread().getName() + "回工位敲代码。。");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }, "Thread_" + i).start();
        }
    }
}
