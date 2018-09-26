package com.fullstacker.study.course.jconsoleTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 利用jConsole监控线程运行状态
 *
 *  示例来自《深入理解java虚拟机》
 * @author xingguishuai
 * @create 2018-09-26-17:05
 **/
public class TreadStateTest {


    /**
     * 线程死循环演示
     */
    public static void createBusyThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {

                }
            }
        }, "testBusyThread");
        thread.start();
    }

    /**
     * 线程锁等待演示
     * @param lock
     */
    public static void createLockThread(final Object lock) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "testLockThread");
        thread.start();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        createBusyThread();
        bufferedReader.readLine();
        Object obj = new Object();
        createLockThread(obj);

    }



}
