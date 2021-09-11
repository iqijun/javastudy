package com.fullstacker.study.course.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Atomic类示例，多线程间保持原子性
 *
 * @author xgs
 * @create 2017-03-14-10:33
 **/
public class AtomicCount {


    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * <p>功能描述：</p>
     * t1,t2,t3三个线程修改atomicInteger，
     * 由于AtomicInteger在进行修改操作时会对值“加锁”，所以AtomicInteger可以保持原子性，
     * 所以在三条线程都进行完修改后，最后的结果为3000，但在三条线程未完全结束时，输出的数字
     * 不一定。
     *
     * @param
     * @return
     * @author xgs
     * @Date 2017-03-16 15:43
     * @since 1.0
     */
    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (count < 1000) {
                    atomicInteger.incrementAndGet();
                    count++;
                }
                System.out.println(Thread.currentThread().getName() + ":" + atomicInteger.get());
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (count < 1000) {
                    atomicInteger.incrementAndGet();
                    count++;
                }
                System.out.println(Thread.currentThread().getName() + ":" + atomicInteger.get());
            }
        }, "t2");
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int count = 0; count < 1000; count++) {
                    atomicInteger.incrementAndGet();
                }
                System.out.println(Thread.currentThread().getName() + ":" + atomicInteger.get());
            }
        }, "t3");
        t1.start();
        t2.start();
        t3.start();
    }
}
