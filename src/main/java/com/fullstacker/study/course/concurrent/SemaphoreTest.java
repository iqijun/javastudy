package com.fullstacker.study.course.concurrent;

import java.util.concurrent.Semaphore;

/**
 * @program: course
 * @description: SemaphoreTest  信号量，  使用场景，如10辆车去抢3个停车位，车辆驶出停车位后通知其他车辆进入停车位
 * @author: xgs
 * @create: 2019-05-02 15:45
 */
public class SemaphoreTest {

    public static void main(String[] args) {

        final Semaphore semaphore = new Semaphore(3);//有3个停车位

        //有10辆车
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire(); //抢到停车位
                        System.out.println("thread_" + finalI + "抢到车位");
                        Thread.sleep(3000);
                        System.out.println("thread_" + finalI + "离开车位");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release();   //释放停车位
                    }
                }
            }, "thread_" + i).start();
        }


    }
}
