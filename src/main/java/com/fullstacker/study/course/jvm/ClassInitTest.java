package com.fullstacker.study.course.jvm;

/**
 * @program: course
 * @description: 类初始化测试
 * @author: xgs
 * @create: 2021-07-14 16:30
 */
public class ClassInitTest {

    static {
        // 静态块中可以给 静态块之后的静态变量赋值，但不能访问
        staticVar = 0;
//        System.out.println(staticVar); // 编译报错
    }
    static int staticVar = 1;

    public static void main(String[] args) {
        System.out.println(ClassInitTest.staticVar);

        System.out.println(Son.a);
    }


}
class Parent{
    static int a = 1;
}

class Son extends Parent{
    static int a = 2;
}