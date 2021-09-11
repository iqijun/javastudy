package com.fullstacker.study.course.JAVASE.map;

import java.util.LinkedHashMap;

/**
 * LinkedHashMap测试类
 *
 * @author xgs
 * @create 2018-08-21-18:14
 **/
public class LinkedHashMapTest {

    public static void main(String[] args) {
        LinkedHashMap<Object, Object> map = new LinkedHashMap<>();
        String tmp = null;
        String str = tmp = "120";
        System.out.println(str);
        System.out.println(tmp);
    }

}
