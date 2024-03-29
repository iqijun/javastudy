package com.fullstacker.study.study.designpattern.future;

public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        
        FutureClient fc = new FutureClient();
        Data data = fc.request("这是一个参数");
        System.out.println("请求发送成功!");
        System.out.println("做其他的事情...");
        
        String result = data.getRequest();
        System.out.println(result);
        
    }
}
