package com.fullstacker.study.course.JAVASE.string;

/**
 * @program: course
 * @description:
 * @author: xgs
 * @create: 2021-09-11 16:29
 */
public class SubStringTest {
    
    public static void main(String[] args) {
        String message = "hello world";
        //        String substring = message.substring(12, 6);
        String newMsg = message.substring(6, 11);
        //                 message.substring(12,6);
        System.out.println(newMsg + ";;;;" + message.length());
    }
}
