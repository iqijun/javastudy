package com.fullstacker.study.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @time: 2021/6/2 16:24
 */
public class SpringTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("/spring-config.xml");
        Object a = classPathXmlApplicationContext.getBean("a");
        System.out.println(a);
    }
}
