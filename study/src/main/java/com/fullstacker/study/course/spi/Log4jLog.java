package com.fullstacker.study.course.spi;

/**
 * @program: course
 * @description:
 * @author: xgs
 * @create: 2021-09-11 21:11
 */
public class Log4jLog implements Log{
    @Override
    public void info(String infos) {
        System.out.println("log4j implements::" + infos);
    }
}
