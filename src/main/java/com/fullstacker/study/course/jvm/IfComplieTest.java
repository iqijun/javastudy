package com.fullstacker.study.course.jvm;

/**
 * @program: course
 * @description: if条件编译
 * @author: xgs
 * @create: 2018-10-29 15:19
 */
public class IfComplieTest {

    public static void main(String[] args) {
        if (true) {
            System.out.println("hahahhahha");
        } else {
            //在编译期间就会执行if判断去除掉不能到达的条件分支 ，因此编译后这个条件分支会消失
            System.out.println("为啥不编译我");

        }

//            while (false){
//                System.out.println();
//            }
    }
}
