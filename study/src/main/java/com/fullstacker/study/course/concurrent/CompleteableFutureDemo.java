package com.fullstacker.study.course.concurrent;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author xingguishuai@xiaomi.com
 * @since 2022-03-22 21:37
 **/
public class CompleteableFutureDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<Double> priceAysn = getPriceAysn();
        System.out.println(priceAysn.get());
    }
    private static Future<Double> getPriceAysn(){
        CompletableFuture<Double> future = new CompletableFuture<>();
        new Thread(()->{
            double p = new Random(1000).nextDouble();
            future.complete(p);

        }).start();


        return  future;
    }
}
