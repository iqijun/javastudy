package com.fullstacker.study.course.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 国美面试题，三个线程依次读取字符串中的n个字符，并输出
 * 同 ReadString.java
 * @author xingguishuai
 * @create 2017-03-07-11:16
 **/
public class PrintThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Print p = new Print("abcdefghijklmnopqrstuvwxyz");
        Thread t1 = new Thread(new Print.PrintOne());
        Thread t2 = new Thread(new Print.PrintTwo());
        Thread t3 = new Thread(new Print.PrintThree());
        t1.start();
        t2.start();
        t3.start();
    }
}

class Print{
    private static  String printStr;
    private static volatile int index;
    private static AtomicInteger sort = new AtomicInteger(0);

    public Print(String str){
        this.printStr=str;
    }

    static class PrintOne implements Runnable{
        public void run() {
            while(true){

                if(sort.get()%3 == 0){
                    synchronized (printStr ){
                        if(index>=printStr.length()){
                            break;
                        }
                        System.out.println(Thread.currentThread().getName()+"："+printStr.substring(index,index+3>=printStr.length()?printStr.length():index+3));
                        sort.incrementAndGet();
                        index += 3;
                    }
                }else if(index>printStr.length()){
                    break;
                }
            }
        }
    }
    static class PrintTwo implements Runnable{
        public void run() {
            while(true){
                if(sort.get()%3 == 1){
                    synchronized (printStr ) {
                        if (index >= printStr.length()) {
                            break;
                        }
                        System.out.println(Thread.currentThread().getName() + "：" + printStr.substring(index, index + 3 >= printStr.length() ? printStr.length() : index + 3));
                        sort.incrementAndGet();
                        index += 3;
                    }
                }else if(index>printStr.length()){
                    break;
                }
            }
        }
    }
    static class PrintThree implements Runnable{
        public void run() {
            while(true){
                if(sort.get()%3 == 2){
                    synchronized (printStr ) {
                        if (index >= printStr.length()) {
                            break;
                        }
                        System.out.println(Thread.currentThread().getName() + "：" + printStr.substring(index, index + 3 >= printStr.length() ? printStr.length() : index + 3));
                        sort.incrementAndGet();
                        index += 3;
                    }
                }else if(index>printStr.length()){
                    break;
                }
            }
        }
    }
}
