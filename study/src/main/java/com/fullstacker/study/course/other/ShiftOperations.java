package com.fullstacker.study.course.other;

/**
 * 位移运算
 *
 * @author xgs
 * @create 2017-12-14-17:21
 **/
public class ShiftOperations {
    
    public static void main(String[] args) {
        //右移运算
        System.out.println(5 >> 1);
        System.out.println(5 >> 2);
        System.out.println(5 >> 3);
        System.out.println(5 >> 4);
        //左移运算相当于乘以2^n次方
        System.out.println(5 << 1); //10
        System.out.println(5 << 2); //20
        System.out.println(5 << 3); //40
        
    }
}
