package com.fullstacker.study.designpattern.MasterWorkers;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * worker类
 *
 * @author xingguishuai
 * @create 2017-04-13-17:21
 **/
public abstract class Worker implements Runnable {
    /**
     * 用来获取master中的任务
     */
    private ConcurrentLinkedQueue<Task> tasks;
    /**
     * 保存结果
     */
    private Map<String, Object> resultMap;

    @Override
    public void run() {
        //只要存在任务就一直循环取出任务并执行
        while (true) {
            //取出一个任务
            Task task = tasks.poll();
            //任务执行完毕
            if (null == task) {
                break;
            }
            Object result = handle(task);
            //保存结果
            resultMap.put(Thread.currentThread().getName() + ":" + task.hashCode(), result);
        }
    }

    public abstract Object handle(Task task);

    public ConcurrentLinkedQueue<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ConcurrentLinkedQueue<Task> tasks) {
        this.tasks = tasks;
    }

    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }
}
