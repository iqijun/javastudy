package com.fullstacker.study.course.concurrent;

/**
 * valitile关键字
 *
 * @author xgs
 * @create 2017-03-13-16:01
 **/
public class VolatileVariable extends Thread {

    private volatile Integer count = 0;

    public void addCount() {
        System.out.println(Thread.currentThread().getName() + "：count自增" + count++);
    }

    public void run() {
        while (count < 3) {
            //do nothing
        }
        //跳出循环结束，子线程结束
        System.out.println("count为" + count);
    }

    public static void main(String[] args) throws InterruptedException {
//        //例1
//        VolatileVariable volatileVariable = new VolatileVariable();
//        //启动子线程，执行run方法
//        volatileVariable.start();
//        Thread.sleep(1000);
//        volatileVariable.addCount();
//        Thread.sleep(1000);
//        volatileVariable.addCount();
//        Thread.sleep(1000);
//        volatileVariable.addCount();

        //例2
        final VolatileVariable volatileVariable = new VolatileVariable();
        //线程T1写数据，T2,T3读取修改
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (volatileVariable.getCount() < 100) {
                    volatileVariable.addCount();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "T1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (volatileVariable.getCount() < 100) {
                    volatileVariable.getCount();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "T2").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (volatileVariable.getCount() < 100) {
                    volatileVariable.getCount();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "T3").start();

        int count = 0;
        while (count < 10) {
            System.out.println(Thread.currentThread().getName() + ":count:" + volatileVariable.getCount());
            count++;
            Thread.sleep(100);
        }
    }

    public Integer getCount() {
        System.out.println(Thread.currentThread().getName() + "：读取count：" + count);
        return this.count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
