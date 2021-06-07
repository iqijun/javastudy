package com.fullstacker.study.course.concurrent;

public class RunThread extends Thread {

    private boolean isRunning = true;

    private void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void run() {
        System.out.println("进入run方法..");
        int i = 0;
        while (isRunning == true) {
            //..
        }
        System.out.println("线程停止");
    }

    public static void main(String[] args) throws InterruptedException {
        RunThread rt = new RunThread();
        rt.start();
        Thread.sleep(1000);
        rt.setRunning(false);
        Thread.sleep(1000);
        rt.start();

        System.out.println("isRunning的值已经被设置了false");
    }


}
