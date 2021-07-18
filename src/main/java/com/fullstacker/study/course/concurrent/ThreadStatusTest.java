package com.fullstacker.study.course.concurrent;

/**
 * @program: course
 * @description: 线程状态测试
 *
 * 有一个4*50的二维数组，用4个线程去分5个阶段去填满它，也就说，第一阶段大家一起填0-9，当大家都填满了0-9，再一起去填10-19，
 * 以此类推，先填满的线程要等着其他线程都填好了，再继续。
 * @author: xingguishuai
 * @create: 2021-06-25 11:15
 */

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ThreadStatusTest {

    public static final char[][] data = new char[4][50]; // 所有线程一起填充的数据

    public static List<Task> taskList = new ArrayList<>();

    public static final Object notifyLock = new Object(); // 另一个锁，不用和数据锁一起，否则的话，会有工作做完了，却无法进入到wait状态的问题

    public static int currentTargetProcess = 9; // 当前所有线程的目标进度是多少

    public static int finishedCount = 0; // 已经完成当前工作的线程数

    static class Task implements Runnable {

        private char mName;
        private int mWorkIndex = 0; // 在哪个index上工作
        private int mCurrentProcess = -1; // 当前已经写到了哪个位置

        public Task(char name, int workIndex) {
            this.mName = name;
            this.mWorkIndex = workIndex;
        }

        @Override
        public void run() {

            boolean isOver = false;

            while (!isOver) {

                // 没有完成自己的工作，努力完成自己的工作
                while (!isFinishedPartJob(currentTargetProcess)) {

                    synchronized (data) {

                        doReallyHardWork(); // 这里做一些耗时工作

                        data[mWorkIndex][++mCurrentProcess] = mName;

                        if (isFinishedPartJob(currentTargetProcess)) {
                            // 自己任务完成了
                            finishedCount++; // 自己报个名，说自己完成了
                            if (finishedCount % 4 == 0) { // 发现自己是最后一个完成的
                                currentTargetProcess += 10; // 自己将大家的目标往后推10
                                //System.out.println(mName + " 是最后完成工作的人，将整体计划+10");
                            }
                            //System.out.println(mName + " 工作完成，通知所有人");
                            synchronized (notifyLock) { // 通知所有人，我的工作做完了，大家是不是要接着干活了
                                notifyLock.notifyAll();
                            }
                        }
                    }
                }

                // 看看大家的工作都做完了吗
                while (!isEveryoneFinished(currentTargetProcess)) {
                    try {
                        synchronized (notifyLock) {
                            // 大家的工作都没做完，我先等待着，等别人来通知我
                            if (isFinishedPartJob(currentTargetProcess)) {
                                notifyLock.wait();
                                //System.out.println("=============================" + mName + "等待");
                            } else {
                                break;
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (mCurrentProcess == data[0].length - 1) {
                    isOver = true;
                }
            }
        }

        /**
         * 是否大家都完成了一阶段的工作了
         * */
        public static boolean isEveryoneFinished(int process) {
            for (Task task : taskList) {
                if (!task.isFinishedPartJob(process)) {
                    return false;
                }
            }
            return true;
        }

        /**
         * 是否自己完成了当前阶段的工作
         * */
        private boolean isFinishedPartJob(int process) {

            boolean r = false;

            if (mCurrentProcess >= process) {
                r = true;
            } else {
                r = false;
            }

            return r;

        }

        /**
         * 做一些真正耗时的工作
         * */
        private void doReallyHardWork() {
            long t = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                File f = new File("README.md");
                f.length();
            }
            //System.out.println(mName + " doReallyHardWork cost: " + (System.currentTimeMillis() - t));

        }
    }

    public static void main(String[] args) {
        Task t1 = new Task('A', 0);
        Task t2 = new Task('B', 1);
        Task t3 = new Task('C', 2);
        Task t4 = new Task('D', 3);

        taskList.add(t1);taskList.add(t2);taskList.add(t3);taskList.add(t4);

        Thread T1 = new Thread(t1);
        Thread T2 = new Thread(t2);
        Thread T3 = new Thread(t3);
        Thread T4 = new Thread(t4);

        Thread[] threadArr = new Thread[]{T1, T2, T3, T4};

        for (int i = 0; i < 300000; i++) {
            if (i == 10) {
                T1.start();
                T2.start();
                T3.start();
                T4.start();
            }
            //cleanScreen();
            System.out.print("\n\n\n\n");
            System.out.print("当前任务目标：" + currentTargetProcess + "\n");
            for (int r = 0; r < data.length; r++) {
                System.out.print('[');
                for (int c = 0; c < data[0].length; c++) {
                    System.out.print(data[r][c]);
                }
                System.out.print("]");
                System.out.print(" " + threadArr[r].getState() + "\n");
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    private static void cleanScreen() {
        System.out.print("\033[H\033[2J");
    }
}

