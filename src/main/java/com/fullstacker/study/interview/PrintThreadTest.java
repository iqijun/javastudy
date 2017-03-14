package com.fullstacker.study.interview;

import java.util.concurrent.atomic.AtomicInteger;


/***
问个多线程的问题：线程1，线程2，线程3，顺序读取字符串"abcdefghijklmnopqrstuvwxyz"
*/
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
	private static int index = 0;
	private static AtomicInteger sort = new AtomicInteger(0);
	
	public Print(String str){
		this.printStr=str;
	}
	
	static class PrintOne implements Runnable{
		public void run() {
			while(true){
				if(sort.get()%3 == 0){
					if(index<printStr.length()){
						System.out.println(Thread.currentThread().getName()+"："+printStr.substring(index,(index+3)>printStr.length()?printStr.length():(index+3)));
						index += 3;
						sort.incrementAndGet();
					}else{
						break;
					}
				}else if(index > printStr.length()){
					break;
				}
			}
		}
	}
	static class PrintTwo implements Runnable{
		public void run() {
			while(true){
				if(sort.get()%3 == 1){
					if(index<printStr.length()){
						System.out.println(Thread.currentThread().getName()+"："+printStr.substring(index,(index+3)>printStr.length()?printStr.length():(index+3)));
						index += 3;
						sort.incrementAndGet();
					}else{
						break;
					}
				}else if(index > printStr.length()){
					break;
				}
			}
		}
	}
	static class PrintThree implements Runnable{
		public void run() {
			while(true){
				if(sort.get()%3 == 2){
					if(index<printStr.length()){
						System.out.println(Thread.currentThread().getName()+"："+printStr.substring(index,(index+3)>printStr.length()?printStr.length():(index+3)));
						index += 3;
						sort.incrementAndGet();
					}else{
						break;
					}
				}else if(index > printStr.length()){
					break;
				}
			}
		}
	}
}
