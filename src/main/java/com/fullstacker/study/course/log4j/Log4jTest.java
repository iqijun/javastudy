package com.fullstacker.study.course.log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description:
 * @time: 2021/6/7 10:40
 */
public class Log4jTest {

    static Logger logger = LoggerFactory.getLogger(Log4jTest.class);

    public static void main(String[] args) {
        if(logger.isInfoEnabled()){
            logger.info("1111");
        }
    }
}
