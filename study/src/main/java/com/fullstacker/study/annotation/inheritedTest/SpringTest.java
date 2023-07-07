package com.fullstacker.study.annotation.inheritedTest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author xingguishuai@xiaomi.com
 * @since 2023-07-07 17:26
 **/
public class SpringTest {
    
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(
                "/spring-config.xml");
        //无论注解是否使用了@Inherited注解，Spring 都能够将带有该注解的类及其子类扫描到
        Map<String, Object> beansWithAnnotation = ac.getBeansWithAnnotation(InheritedTest.class);
        beansWithAnnotation.forEach((k,v)->{
            System.out.println(k+" : "+v);
        });
    }

}
