package com.fullstacker.study.course.other;

/**
 *
 * @program: course
 * @description: 测试类的初始化顺序
 * @author: xingguishuai
 * @create: 2019-03-19 10:01
 *
 *
 * Java中赋值顺序：
 * 1. 父类的静态变量赋值
 * 2. 自身的静态变量赋值
 * 3. 父类成员变量赋值和父类块赋值
 * 4. 父类构造函数赋值
 * 5. 自身成员变量赋值和自身块赋值
 * 6. 自身构造函数赋值
 *
 * 在这个
 */
public class StaticTest {
    public static void main(String[] args)
    {
        staticFunction();
    }

    static StaticTest st = new StaticTest();

    static
    {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    StaticTest()
    {
        System.out.println("3");
        System.out.println("a="+a+",b="+b);
    }

    public static void staticFunction(){
        System.out.println("4");
    }

    int a=110;
    static int b =112;
}
