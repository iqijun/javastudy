package com.fullstacker.study.course.concurrent;

/**
 * 多线程
 *
 * @author xgs
 * @create 2017-02-27-10:04
 **/
public class MyThread extends Thread {

    private Integer count = 5;

    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + ":" + count);
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread t1 = new Thread(myThread, "T1");
        Thread t2 = new Thread(myThread, "T2");
        Thread t3 = new Thread(myThread, "T3");
        Thread t4 = new Thread(myThread, "T4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.stop();
//        try {
//            String s = testThrowException();
//        } catch (NullPointerException e) {
//            String message = e.getMessage();
//            System.out.println(message);
//            e.printStackTrace();
//        }
    }
//    private static String testThrowException() throws  NullPointerException{
//        throw  new  NullPointerException("dkkdjk");
//    }

//   new Thread(new RunThread) ;
}
