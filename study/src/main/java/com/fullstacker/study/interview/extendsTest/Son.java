package com.fullstacker.study.interview.extendsTest;

/**
 * @program: course
 * @description: 子类
 * @author: xgs
 * @create: 2021-04-04 16:53
 */
public class Son extends Parent {
    private  String  firstName;

    private String lastName;

    private int  age;

//    public Son(){
        // 父类构造方法被调用前，无法使用子类的属性
//        super(firstName, lastName, age);
//    }

    public Son(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        System.out.println(" constructor of son");
    }
}
