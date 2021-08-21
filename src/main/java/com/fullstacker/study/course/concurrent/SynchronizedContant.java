package com.fullstacker.study.course.concurrent;

/**
 * 常量做为synchronized的对象
 *
 * @author xgs
 * @create 2017-03-01-13:59
 **/
public class SynchronizedContant {
    int i = 0;


    public void synchronizedContantMethod() throws InterruptedException {
        String lock = new String("123");
        synchronized (lock) {
            while (true) {
                Thread.sleep(1000);
                System.out.println("Thread name:" + Thread.currentThread().getName());
                i++;
            }
        }
    }

    public static void main(String[] args) {
        final SynchronizedContant synchronizedContant1 = new SynchronizedContant();
        final SynchronizedContant synchronizedContant2 = new SynchronizedContant();

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                try {
                    synchronizedContant1.synchronizedContantMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1");
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                try {
                    synchronizedContant2.synchronizedContantMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2");
        thread1.start();
        thread2.start();
    }
}
