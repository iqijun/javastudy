package com.fullstacker.study.course.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @program: course
 * @description: jdk spi test
 * @author: xgs
 * @create: 2021-09-11 20:54
 */
public class JDKSPITest {
    
    public static void main(String[] args) {
        ServiceLoader<Log> serviceLoader = ServiceLoader.load(Log.class);
        //        for (Log log : serviceLoader) {
        //            log.info("打印日志");
        //        }
        Iterator<Log> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            Log next = iterator.next();
            next.info("打印日志");
        }
        
    }
}
