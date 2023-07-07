package com.fullstacker.study.course.jvm;

/**
 * <p>功能描述：类初始化测试</p>
 *
 * @author: xgs
 * @Date: 2018/10/19 14:36
 * @since 1.0
 */
public class ClinitTest {

    static int beforeStaticVar = 1;

    static {
        beforeStaticVar = 10;
        //        System.out.println(beforeStaticVar);
        afterStaticVar = 10;  //位于静态块之后的变量可以在静态块中赋值 但不能在静态块中引用
        //        System.out.println(afterStaticVar);  // 编译错误 无法引用在静态块后的变量
    }

    //位于静态块之后的变量
    static int afterStaticVar = 1;

    static class Parent {

        static int varA = 1;

        static {
            varA = 10;
        }
    }

    static class Sub extends Parent {

        static int varB = varA;

        static {
            varB = 5;
        }
    }

    public static void main(String[] args) {
        System.out.println(Sub.varB);
    }
}
