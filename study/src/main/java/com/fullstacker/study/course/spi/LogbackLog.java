package com.fullstacker.study.course.spi;

/**
 * @program: course
 * @description: 模拟logback
 * @author: xgs
 * @create: 2021-09-11 20:58
 */
public class LogbackLog implements Log{
    @Override
    public void info(String infos) {
        System.out.println("logback implements:" + infos);
    }
}
