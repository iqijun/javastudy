package com.fullstacker.study.course.concurrent;

/**
 * join方法使用示例
 *
 * @author xgs
 * @create 2017-03-24-14:22
 **/
public class ThreadJoin {
    /**
     * <p>功能描述：在执行thread2过程中，调用thread1.join()方法后，thread2线程暂停，
     * 而后thread1继续执行，待thread1执行完毕thread2继续执行</p>
     *
     * @param
     * @return
     * @author xgs
     * @Date 2017-03-24 14:27
     * @since 1.0
     */
    public static void main(String[] args) {

        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i < 10) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    i++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t1");
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i < 10) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    i++;
                    try {
                        thread1.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t2");
        thread2.start();
    }

}
