package com.fullstacker.study.course.concurrent;


import java.util.Random;
import java.util.concurrent.*;
import java.util.function.Supplier;

/**
 * @author xingguishuai@xiaomi.com
 * @since 2022-03-22 21:37
 **/
public class CompleteableFutureDemo {
    
    
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        Future<Double> futrue = getPriceAysn();
        Double aDouble = futrue.get();
        System.out.println(aDouble);
        
    }
    
    private static Future<Double> getPriceAysn() {
        CompletableFuture<Double> future = new CompletableFuture<>();
        Thread t = new Thread(() -> {
            try {
                double p = new Random(1000).nextDouble();
                //                如果抛异常前complete则可以正常返回
                future.complete(p);
                throw new RuntimeException("就是错了");
                
            } catch (Exception e) {
                //                e.printStackTrace();
                // 如果没有completeExceptionally，当产生异常后，主线程会被阻塞，直到超时；如果没有设置超时就会一直阻塞
                future.completeExceptionally(e);
            }
            
            
        });
        t.setDaemon(true);
        t.start();
        
        return future;
    }
    
}
