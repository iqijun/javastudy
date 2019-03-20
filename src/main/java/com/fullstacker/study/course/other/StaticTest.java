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
 * 在这个列子中会先初始化StaticTest类的静态变量，首先是st变量，但st变量是该类的一个个对象，所以此时会将对象的初始化嵌套到静态变量初始化
 * ，初始化这个变量时，会先执行代码块2 ，然后初始化变量a=110,初始化完成后执行构造函数，在执行构造函数时，a变量已经被初始化，但StaticTest类的
 * 静态变量b还未初始化，所以输出a=110, b=0;
 * 完成st变量的初始化后，执行静态代码块1 ，然后运行staticFunction方法
 *
 *
 */
public class StaticTest {
    public static void main(String[] args)
    {
        staticFunction();
    }

    static StaticTest st = new StaticTest();
    // 静态代码块1
    static
    {
        System.out.println("1");
    }
    // 代码块2
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
