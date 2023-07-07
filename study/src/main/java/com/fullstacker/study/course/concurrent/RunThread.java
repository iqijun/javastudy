package com.fullstacker.study.course.concurrent;

public class RunThread extends Thread {
    
    // 不使用volatile关键字，子线程将无法获取到变量值改变
    private /*volatile*/ boolean isRunning = true;
    
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
        System.out.println("线程状态1" + rt.getState());
        
        Thread.sleep(1000);
        System.out.println("线程状态2" + rt.getState());
        rt.setRunning(false);
        Thread.sleep(1000);
        //        rt.start();
        
        System.out.println("isRunning的值已经被设置了false");
    }
    
    
}
