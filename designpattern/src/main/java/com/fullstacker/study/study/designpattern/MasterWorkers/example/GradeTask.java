package com.fullstacker.study.study.designpattern.MasterWorkers.example;

import com.fullstacker.study.study.designpattern.MasterWorkers.Task;

/**
 * 计算学生成绩任务
 *
 * @author xgs
 * @create 2017-04-13-18:30
 **/
public class GradeTask implements Task {
    /**
     * 学生ID
     */
    private Long sutudentId;
    /**
     * 数学成绩
     */
    private float mathGrade;
    /**
     * 语文成绩
     */
    private float chineseGrade;

    public Long getSutudentId() {
        return sutudentId;
    }

    public void setSutudentId(Long sutudentId) {
        this.sutudentId = sutudentId;
    }

    public float getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(float mathGrade) {
        this.mathGrade = mathGrade;
    }

    public float getChineseGrade() {
        return chineseGrade;
    }

    public void setChineseGrade(float chineseGrade) {
        this.chineseGrade = chineseGrade;
    }

    @Override
    public Object doTask() {
        return chineseGrade + mathGrade;
    }
}
