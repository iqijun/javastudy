package com.fullstacker.study.course.concurrent;

/**
 * 锁对象的改变问题
 *
 * @author xgs
 * @create 2017-03-06-18:31
 **/
public class ChangeLock {

    private String lock = "lock";

    private void method() {
        synchronized (lock) {
            try {
                System.out.println("当前线程 : " + Thread.currentThread().getName() + "开始");
                //lock改变了  锁不起作用了 t2会在锁改变的时候就开始执行了
                lock = "change lock";
                Thread.sleep(500);
                System.out.println("当前线程 : " + Thread.currentThread().getName() + "结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        final ChangeLock changeLock = new ChangeLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                changeLock.method();
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                changeLock.method();
            }
        }, "t2");
        t1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }

}
