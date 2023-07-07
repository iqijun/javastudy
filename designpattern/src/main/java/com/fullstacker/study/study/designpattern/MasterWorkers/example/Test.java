package com.fullstacker.study.study.designpattern.MasterWorkers.example;

import com.fullstacker.study.study.designpattern.MasterWorkers.Master;
import com.fullstacker.study.study.designpattern.MasterWorkers.Worker;

import java.util.Map;
import java.util.Random;


/**
 * 测试master worker模式
 *
 * @author xgs
 * @create 2017-04-13-18:39
 **/
public class Test {
    
    public static void main(String[] args) {
        Worker worker = new GradeWorker();
        
        Master master = new Master(worker, Runtime.getRuntime().availableProcessors());
        Random rundom = new Random();
        for (int i = 0; i < 4; i++) {
            GradeTask gradeTask = new GradeTask();
            gradeTask.setChineseGrade(rundom.nextFloat() * 100);
            gradeTask.setMathGrade(rundom.nextFloat() * 100);
            master.submitTask(gradeTask);
        }
        master.execute();
        while (true) {
            if (master.isComplate()) {
                Map<String, Object> result = master.getResult();
                for (Map.Entry<String, Object> me : result.entrySet()) {
                    System.out.println(me.getKey() + ":::" + me.getValue());
                }
                break;
            }
        }
    }
}
