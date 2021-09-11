package com.fullstacker.study.course.concurrent;

/**
 * 多线程访问同一个类的多个对象相同一个方法
 *
 * @author xgs
 * @create 2017-02-28-11:01
 **/
public class MutiThread {

    public static synchronized void print(String name) throws InterruptedException {
        Integer age;
        if ("Tom".equalsIgnoreCase(name)) {
            age = 10;
            System.out.println("name:" + name + " has set age");
            Thread.sleep(1000);
        } else {
            age = 5;
            System.out.println("name:" + name + " has set age");
        }
        System.out.println("name:" + name + " age:" + age);
    }

    public static void main(String[] args) {
        final MutiThread m1 = new MutiThread();
        final MutiThread m2 = new MutiThread();

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                try {
                    m1.print("tom");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                try {
                    m2.print("tomcat");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
