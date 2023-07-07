package com.fullstacker.study.study.designpattern.MasterWorkers.example;

import com.fullstacker.study.study.designpattern.MasterWorkers.Task;
import com.fullstacker.study.study.designpattern.MasterWorkers.Worker;

/**
 * 计算成绩的worker
 *
 * @author xgs
 * @create 2017-04-13-18:34
 **/
public class GradeWorker extends Worker {
    
    @Override
    public Object handle(Task task) {
        return task.doTask();
    }
}
