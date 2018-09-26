package com.fullstacker.study.course.jconsoleTest;

/**
 * 线程死锁测试
 *示例来自《深入理解java虚拟机》
 * @author xingguishuai
 * @create 2018-09-26-17:32
 **/
public class LockThreadTest {

     static class SynAddRunable implements  Runnable{
         Integer a,b;

         public SynAddRunable(Integer a,Integer b){
            this.a = a;
             this.b = b;
         }
         @Override
         public void run() {
             synchronized (a){
                 synchronized (b){
                     System.out.println(a+b);
                 }
             }
         }
     }

     public static void main(String[] args){
        for (int i=0;i<100;i++){
            new Thread(new SynAddRunable(1,2)).start();
            new Thread(new SynAddRunable(1,2)).start();
        }
     }
}
