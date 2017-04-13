package com.fullstacker.study.designpattern.MasterWorkers;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * master类
 *
 * @author xingguishuai
 * @create 2017-04-13-17:21
 **/
public class Master {
    /**
     *用来保存任务,由于会涉及多线程共同处理任务所以使用concurrent包
     */
    private ConcurrentLinkedQueue<Task> tasks = new ConcurrentLinkedQueue<Task>();
    /**
     * 保存结果 由于会涉及多线程共同处理任务所以使用concurrent包
     */
    private Map<String,Object> resultMap = new ConcurrentHashMap<String, Object>();
    /**
     * 用来保存workers
     */
    private HashMap<String,Thread> workers = new HashMap<String, Thread>();
    /**
    * <p>功能描述：构造函数，指定work和work数量</p>
    * @return
    * @param
    * @author xingguishuai
    * @Date 2017-04-13 17:50
    * @since 1.0
    */
    public Master(Worker worker,int workerCount){
        worker.setResultMap(resultMap);
        worker.setTasks(tasks);
        for (int i = 0;i < workerCount;i++){
            String workName = "workerName-" + i;
            workers.put(workName,new Thread(worker,workName));
        }
    }
    /**
    * <p>功能描述：提交任务</p>
    * @return
    * @param
    * @author xingguishuai
    * @Date 2017-04-13 18:02
    * @since 1.0
    */
    public void submitTask(Task task){
        tasks.add(task);
    }
    /**
    * <p>功能描述：master调用work执行任务</p>
    * @return
    * @param
    * @author xingguishuai
    * @Date 2017-04-13 18:01
    * @since 1.0
    */
    public void execute(){
        for (Map.Entry<String, Thread> entry : workers.entrySet()) {
            entry.getValue().start();
        }
    }
    /**
    * <p>功能描述：判断任务是否执行完</p>
    * @return
    * @param
    * @author xingguishuai
    * @Date 2017-04-13 18:06
    * @since 1.0
    */
    public boolean isComplate(){
        for (Map.Entry<String, Thread> entry : workers.entrySet()) {
            //如果有一个线程的状态不为TERMINATED，即可标志任务未完成
            if(!entry.getValue().getState().equals(Thread.State.TERMINATED)){
                return  false;
            }
        }
        return  true;
    }
    /**
    * <p>功能描述：返回结果集</p>
    * @return
    * @param
    * @author xingguishuai
    * @Date 2017-04-13 18:26
    * @since 1.0
    */
    public Map<String, Object> getResult(){
        return  resultMap;
    }
}
