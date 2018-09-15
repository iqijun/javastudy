package com.fullstacker.study.course.JAVASE.string;

/**
 * @author xingguishuai
 * @create 2018-09-15-11:35
 **/
public class StringInternTest {

    public static void main(String[] args){

        StringBuffer sb1 = new StringBuffer();
        sb1.append("计算机").append("软件");
        String str1 = sb1.toString();
        System.out.println(str1.intern() == str1); // false

        /****
         *  常量池中为什么会有“java”这个字符串呢？
         * 原因是这样的，并没有java字符串常量池中，有默认字符串常量这样的机制。而是其实jvm从启动，
         * 到执行main里面的第一条代码，要经历很多的，比如加载rt.jar里面所有的Class，加载一个class肯定要执行static{}中内容
         * ，况且rt.jar中的jdk的类里面有很多xxx.startWith("java")或者其他用到"java"的代码，
         * jvm启动的时候直接按照常量加载进来了丢到internmap里面了
         */
        StringBuffer sb2 = new StringBuffer();
        sb2.append("ja").append("va");
        String str2 = sb1.toString();
        System.out.println(str2.intern() == str2); // true

        System.out.println("===========================");

        //在创建abc1时，创建了一个堆中的对象，和一个常量池中的对象
        String abc1 = new String("abc");
        //在创建abc2时只创建了一个堆中的对象，不再创建常量池中的对象
        String abc2 = new String("abc");
        System.out.println(abc1 == abc2);
        System.out.println(abc1.intern() == abc1);
        System.out.println(abc1.intern() == abc2);
        System.out.println(abc1.intern() == abc2.intern());


        System.out.println("===========================");
    }
}
