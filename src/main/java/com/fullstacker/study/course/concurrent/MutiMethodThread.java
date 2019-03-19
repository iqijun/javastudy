package com.fullstacker.study.course.concurrent;

/**
 * 多线程访问同一对象的多个方法
 *
 * 如该代码示例：如果两个方法都加锁，则tread2会“等待”thread1 执行完释放锁后再执行print2方法
 * 如果一个方法有锁，一个方法没锁，则thread2可以异步的调用print2方法
 *
 * @author xingguishuai
 * @create 2017-02-28-11:18
 **/
public class MutiMethodThread {

    public  synchronized void  print1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+ " method is print1");
        Thread.sleep(3000);
        System.out.println("method print1 done");
    }

    public /*synchronized*/ void print2(){
        System.out.println(Thread.currentThread().getName() + " method is print2");
    }

    public static void main(String[] args){
        final MutiMethodThread mutiMethodThread = new MutiMethodThread();

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                try {
                    mutiMethodThread.print1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"thread1");

        Thread thread2 = new Thread(new Runnable() {
            public void run() {

                    mutiMethodThread.print2();

            }
        },"thread2");
        thread1.start();
        thread2.start();
    }
}
