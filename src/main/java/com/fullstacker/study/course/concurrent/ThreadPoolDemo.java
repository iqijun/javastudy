package com.fullstacker.study.course.concurrent;

import java.util.concurrent.*;

/**
 * @program: course
 * @description: 线程池使用示例
 * @author: xingguishuai
 * @create: 2019-05-18 16:10
 */
public class ThreadPoolDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                19,
                100,
                100,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(10),
                new ThreadPoolExecutor.CallerRunsPolicy());
//        一般不使用Executors提供的这个几个线程池 因为他使用阻塞队列是无界的，有可能会造成OOM
//        Executors.newCachedThreadPool();
//        Executors.newFixedThreadPool(10);
//        Executors.newScheduledThreadPool(10);
//        Executors.newSingleThreadExecutor();

        TaskWithReturn taskWithReturn = new TaskWithReturn();
        Future<Integer> future = threadPoolExecutor.submit(taskWithReturn);
        System.out.println(future.get());
        threadPoolExecutor.shutdown();
//        FutureTask<Integer> taskWithReturnFutureTask = new FutureTask<Integer>(taskWithReturn);
//        Thread thread = new Thread(taskWithReturnFutureTask);
//        thread.start();
    }

    private static class TaskWithReturn implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println(Thread.currentThread().getName());
            return 1234;
        }
    }
}
