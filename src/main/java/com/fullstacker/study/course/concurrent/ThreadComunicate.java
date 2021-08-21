package com.fullstacker.study.course.concurrent;

/**
 * 线程间通讯
 *
 * @author xgs
 * @create 2017-03-17-13:25
 **/
public class ThreadComunicate {

    public static void main(String[] args) throws InterruptedException {
        final Object lock = new Object();
        int count = 0;

        Thread thread = new Thread(new Runnable() {
            int count = 0;

            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {
                        System.out.println(Thread.currentThread().getName() + ":子线程:" + count);

                        count++;
                        if (count == 5) {
                            lock.notify();
//                            try {
//                                lock.wait();
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
                        }
                        if (count > 10) {
                            break;
                        }
                    }
                }

            }
        });
        thread.start();
        synchronized (lock) {
            while (true) {
                System.out.println(Thread.currentThread().getName() + ":" + count);
                count++;
                if (count == 5) {
                    lock.wait();
                }
                if (count > 10) {
                    break;
                }
            }
        }
    }

}
