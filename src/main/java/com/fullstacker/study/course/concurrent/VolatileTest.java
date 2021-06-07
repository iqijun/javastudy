package com.fullstacker.study.course.concurrent;

/**
 * volatile 用例
 *
 * @author xingguishuai
 * @create 2017-03-16-15:56
 **/
public class VolatileTest {

    public int count = 0;

    public static void main(String[] args) throws InterruptedException {
        VolatileTest volatileTest = new VolatileTest();
        volatileTest.test();
    }

    /**
     * <p>功能描述：</p>
     *
     * @param
     * @return
     * @author xingguishuai
     * @Date 2017-03-16 16:01
     * @since 1.0
     */
    public void test() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    count++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + ":" + count);
            }
        }, "T1");
        t1.start();
        while (count < 1000) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + ":" + count);
        }
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 1000; i++) {
//                    count++;
//                }
//                System.out.println(Thread.currentThread().getName() + ":" + count);
//            }
//        }, "T2");
//        Thread t3 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 1000; i++) {
//                    count++;
//                }
//                System.out.println(Thread.currentThread().getName() + ":" + count);
//            }
//        }, "T3");

//        t2.start();
//        t3.start();
    }
}
